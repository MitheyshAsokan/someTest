
import java.util.ArrayList;

public class Node implements Comparable<Node> {

    private int depth;

    /// <summary>
    /// The actual cost/value, g(n), of reaching this node via the path.
    /// </summary>
    private int cost; // don't init, let the compiler handle

    /// <summary>
    /// The estimated cost/value, h(n), of reaching goal from this node.
    /// </summary>
    private int heuristic;

    /// <summary>
    /// The parent of this node. If null, then we are the root.
    /// </summary>
    private Node parent;

    /// <summary>
    /// The BidIdx is index the into the Problem bids member.
    /// </summary>
    private Bid bid = null;

    private Bid.BidRequest mergedRequest;

    private Bid[] fringeBids;

    public Node(Bid Bid, Node parent, Problem problem) {
        this.bid = Bid;
        this.parent = parent;
        if (parent == null) {
            this.cost = Bid.getAmount();
            this.depth = 1;
        } else {
            this.cost = parent.cost + Bid.getAmount();
            this.depth = parent.depth + 1;
        }
        this.computeHeuristicAndFringeBids(problem);
    }

    public int getDepth() {
        return depth;
    }

    public int getCost() {
        return cost;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public Node getParent() {
        return parent;
    }

    public Bid getBid() {
        return bid;
    }

    public Bid.BidRequest getMergedRequest() {
        return mergedRequest;
    }

    public Bid[] getFringeBids() {
        return fringeBids;
    }

    private void computeMergedRequest() {
        this.mergedRequest = new Bid.BidRequest(this.bid.getRequest().getCount());

        for (int i = 0; i < this.mergedRequest.getCount(); ++i) {
            if (this.parent == null || this.parent.mergedRequest.get(i) == 0) {
                this.mergedRequest.set(i, this.bid.getRequest().get(i));
                // this.mergedRequest[i] = this.bid.Request[i];
            } else {
                mergedRequest.set(i, parent.mergedRequest.get(i));
                // this.mergedRequest[i] = this.parent.MergedReqest[i];

                // there should not be a conflict, but check
                if (this.bid.getRequest().get(i) != 0 && this.bid.getRequest()
                        .get(i) != this.parent.mergedRequest.get(i)) {
                    throw new RuntimeException("bad logic in ComputeMergedRequest");
                }
            }
        }
    }

    private boolean selfOrAncestor(Node currNode, Bid otherBid) {
        if (currNode == null) {
            return false;
        }
        if (currNode.bid.getId() == otherBid.getId()) {
            return true;
        }
        return selfOrAncestor(currNode.parent, otherBid);
    }

    private void computeHeuristicAndFringeBids(Problem problem) {
        this.computeMergedRequest();
        this.heuristic = 0;
        ArrayList<Bid> tmpFringeBids = new ArrayList<>();
        for (int i = 0; i < problem.getBids().length; ++i) {
            Bid otherBid = problem.getBids()[i];
            if (!this.selfOrAncestor(this, otherBid)) {
                if (!this.mergedRequest.conflictExists(otherBid.getRequest())) {
                    this.heuristic += otherBid.getAmount();
                    tmpFringeBids.add(otherBid);
                }
            }
        }
        this.fringeBids = new Bid[tmpFringeBids.size()];
        for (int i = 0; i < this.fringeBids.length; ++i) {
            this.fringeBids[i] = tmpFringeBids.get(i);
        }
    }

    @Override
    public int compareTo(Node rhsNode) {
        // this will sort in ascending order

        int lhsF = this.cost + this.heuristic;
        int rhsF = rhsNode.cost + rhsNode.heuristic;
        if (lhsF > rhsF) {
            return 1;
        } else if (lhsF < rhsF) {
            return -1;
        }
        return 0;
    }

}
