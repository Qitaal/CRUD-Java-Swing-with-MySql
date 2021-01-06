package formsiswa.model;


public class Siswa {
    private int id;
    private String nis;
    private String nama;
    private String jurusan;
    private String jk;
    private String  alamat;

    public Siswa(int id, String nis, String nama, String jurusan, String jk, String alamat) {
        this.id = id;
        this.nis = nis;
        this.nama = nama;
        this.jurusan = jurusan;
        this.jk = jk;
        this.alamat = alamat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }    
}
