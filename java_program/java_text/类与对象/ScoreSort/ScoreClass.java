class ScoreClass {

    private int no;
    private int score;

    public ScoreClass() {
        no = 100;
        score = 0;
    }

    ScoreClass(final int n, final int s) {
        no = n;
        score = s;
    }

    public void setInfo(final int n, final int s) {
        no = n;
        score = s;
    }

    public int getScore() {
        return score;
    }

    public int getno() {
        return no;
    }

    @Override
    public String toString() {
        return no + "\t" + score;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ScoreClass other = (ScoreClass) obj;
        return other.no == this.no && other.score == score;
    }
}