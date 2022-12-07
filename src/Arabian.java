public enum Arabian {
    I(1), II(2), III(3), IV(4), V(5),
    VI(6), VII(7), VIII(8), IX(9), X(10);

    public int rimNumber;

    Arabian(int rimNumber) {
        this.rimNumber = rimNumber;
    }

    public int getRimNumber() {
        return rimNumber;
    }

    public void setRimNumber(int rimNumber) {
        this.rimNumber = rimNumber;
    }
}