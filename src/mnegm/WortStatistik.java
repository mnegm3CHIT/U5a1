package mnegm;

public class WortStatistik {
    private int r, f, total;

    public WortStatistik(int r, int f) {
        this.r = Math.max(r, 0);
        this.f = Math.max(f, 0);
        this.total = this.r + this.f;

    }
    public void addR() {
        this.r += 1;
        this.total += 1;
    }

    public void addF() {
        this.f += 1;
        this.total += 1;
    }

    public int getR() {
        return r;
    }

    public int getF() {
        return f;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Von "+ this.total +" Abfrage(n) sind "+ this.r +" richtig und "+ this.f  +" falsch";
    }
}
