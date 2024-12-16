package entity;



public class BarangMasukKeluar {

    private int id;
    private String kdBarang;
    private int jumlah;

    private String tanggal; // Use String if datetime format is not yet defined
    private Tipe tipe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKdBarang() {
        return kdBarang;
    }

    public void setKdBarang(String kdBarang) {
        this.kdBarang = kdBarang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Tipe getTipe() {
        return tipe;
    }

    public void setTipe(Tipe tipe) {
        this.tipe = tipe;
    }

    // Enum for the 'tipe' field
    public enum Tipe {
        MASUK,
        KELUAR
    }

}
