public class Bid {
    public static class BidRequest {
        private int[] requests;

        public BidRequest(int numSensors) {
            this.requests = new int[numSensors];
            for (int i = 0; i < numSensors; ++i) {
                this.requests[i] = 0;
            }
        }

        public int get(int i) {
            return this.requests[i];
        }

        public void set(int i, int value) {
            this.requests[i] = value;
        }

        public int getCount() {
            return this.requests.length;
        }

        public boolean conflictExists(BidRequest otherBidRequest) {
            if (otherBidRequest.getCount() != this.getCount()) {
                throw new RuntimeException("bid requests must be same size");
            }

            for (int i = 0; i < this.getCount(); ++i) {
                if (this.get(i) != 0 && otherBidRequest.get(i) != 0) {
                    if (this.get(i) != otherBidRequest.get(i)) {
                        return true;
                    }
                }
            }
            return false;
        }

    }

    private BidRequest request;

    private String id;

    private int amount;

    public Bid(String id, int bidAmount, int numSensors) {
        this.id = id;
        this.amount = bidAmount;
        this.request = new BidRequest(numSensors);
    }

    public BidRequest getRequest() {
        return request;
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

}
