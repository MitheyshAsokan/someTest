import java.util.Random;

public class Problem {
    private int numSensors;

    private String id;

    private int numBidsAdded = 0;

    private Bid[] bids;

    public Problem(String id, int numSensors, int numBids) {
        this.id = id;
        this.numSensors = numSensors;
        this.bids = new Bid[numBids];
    }

    public void addBid(Bid bid) {
        this.bids[numBidsAdded] = bid;
        ++numBidsAdded;
    }

    public void createRandom() {
        Random rand = new Random(212);
        for (int b = 0; b < this.bids.length; ++b) {
            int amount = (int) (10 * rand.nextDouble());
            // if ( rand.NextDouble() < 0.1 )
            // amount = (int)(100 * rand.NextDouble()) ;
            this.bids[b] = new Bid(String.format("%d", b), amount, this.numSensors);
            for (int s = 0; s < this.numSensors; ++s) {
                if (rand.nextDouble() < 0.35) {
                    bids[b].getRequest().set(s, rand.nextInt(3) + 1);
                    // this.Bids[b].Request[s] = rand.nextInt(3) + 1;
                } else {
                    bids[b].getRequest().set(s, 0);
                    // this.Bids[b].Request[s] = 0;
                }
            }
        }
    }

    public void print() {
        System.out.println("num sensors = " + this.numSensors);
        System.out.println("num bids = " + this.bids.length);
        for (int b = 0; b < this.bids.length; ++b) {
            System.out.println("Bid " + this.bids[b].getId() + ":  ");
            for (int s = 0; s < this.bids[b].getRequest().getCount(); ++s) {
                System.out.println(this.bids[b].getRequest().get(s) + " ");
            }
            System.out.println(" " + this.bids[b].getAmount());
        }
    }

    public String getId() {
        return id;
    }

    public Bid[] getBids() {
        return bids;
    }

}
