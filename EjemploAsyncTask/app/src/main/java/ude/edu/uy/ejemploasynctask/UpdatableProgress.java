package ude.edu.uy.ejemploasynctask;

public interface UpdatableProgress {
    public abstract void update(int count);
    public abstract void cancel();
}
