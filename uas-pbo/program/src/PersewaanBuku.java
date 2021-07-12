import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.*;
import java.time.LocalDate;


public class PersewaanBuku {
    private JLabel judulFormnya;
    private JPanel PanelUtama;
    private JPanel hariTanggal;
    private JPanel panelJudulBiaya;
    private JLabel labelTanggal;
    private JLabel labelHari;
    private JTextField fieldTanggal;
    private JTextField fieldHari;
    private JPanel panelTabel;
    private JTable tableBuku;
    private JTextField fieldBuku;
    private JLabel labelJudul;
    private JTextField textField3;
    private JLabel rupiahBiaya;
    private JPanel panelTombol;
    private JButton btnSimpan;
    private JButton btnKembaliBuku;
    private JButton btnEdit;
    private JButton btnDelete;

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/perpus_sekolah";
    static final String USER="root";
    static final String PASS="";

    static Connection sambungkan;
    static Statement statmt;
    static ResultSet setHasil;

    LocalDate tanggalTerkini=LocalDate.now();
    LocalDate hariTerkini=LocalDate.parse(String.valueOf(tanggalTerkini));

    public static void main(String[] args) {
        JFrame frame = new JFrame("PersewaanBuku");
        frame.setContentPane(new PersewaanBuku().PanelUtama);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1024,720);
    }

    public PersewaanBuku() {
        //set tanggal (ubah property milik JTextField bernama 'fieldTanggal')
        fieldTanggal.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String tampungTanggal= String.valueOf(tanggalTerkini);
                fieldTanggal.setText(tampungTanggal);
            }
        });
        //menampilkan tabel dari database di dalam JTable (ubah property milik JTable bernama 'tableBuku')
        tableBuku.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //memanggil method show
                show();
            }
        });
        //set hari (ubah property milik JTextField bernama 'fieldHari')
        fieldHari.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //memanggil method getDayofWeek, kemudian di ubah ke dalam string
                String tampungHari=String.valueOf(hariTerkini.getDayOfWeek());
                fieldHari.setText(tampungHari);
            }
        });

    }




    //insert ketika tombol 'Simpan' di-klik
    public void insert(String judulBuku, LocalDate tanggalPinjam, LocalDate wajibKembali ){
        try {
            //register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);

            //menyambungkan ke database
            sambungkan= DriverManager.getConnection(DB_URL,USER,PASS);

            //perintah sql-nya
            String sql="INSERT INTO sewabuku (judul, tanggal_pinjam, tanggal_harus_kembali) VALUES (?, ?, ?)";

            //Prepared statement untuk menghindari sql injection
            PreparedStatement prstmt= sambungkan.prepareStatement(sql);
            prstmt.setString(1, judulBuku);
            prstmt.setString(2, String.valueOf(tanggalPinjam));
            prstmt.setString(3, String.valueOf(wajibKembali));

            prstmt.execute();

            //tutup koneksi
            sambungkan.close();


        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //menampilkan isi dari tabel pada database
    public void show(){
        try {
            //register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);

            //menyambungkan ke database
            sambungkan= DriverManager.getConnection(DB_URL,USER,PASS);

            //mengatur table head atau nama kolom
            DefaultTableModel kerangkaTabel = new DefaultTableModel();
            kerangkaTabel.addColumn("Nomer");
            kerangkaTabel.addColumn("Judul Buku");
            kerangkaTabel.addColumn("Tanggal Pinjam");
            kerangkaTabel.addColumn("Tanggal Harus Kembali");
            kerangkaTabel.addColumn("Tanggal Kembali");
            kerangkaTabel.addColumn("Denda");
            kerangkaTabel.addColumn("Biaya Sewa");

            //perintah sql nya
            statmt=sambungkan.createStatement();
            String sql = "SELECT * FROM sewabuku";

            //eksekusi perintah sql
            setHasil= statmt.executeQuery(sql);

            while (setHasil.next()){
                kerangkaTabel.addRow(new Object[] {
                        setHasil.getString("id"),
                        setHasil.getString("judul"),
                        setHasil.getString("tanggal_pinjam"),
                        setHasil.getString("tanggal_harus_kembali"),
                        setHasil.getString("tanggal_kembali"),
                        setHasil.getString("denda"),
                        setHasil.getString("biaya_sewa")
                });

            }
            setHasil.close();
            sambungkan.close();
            statmt.close();

            //set table model tadi ke dalam JTables
            tableBuku.setModel(kerangkaTabel);
        }catch (SQLException eksepsi){
            eksepsi.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //update ketika tombol 'btnKembaliBuku' di-klik
    public void update(LocalDate tanggalKembali, int denda,int biayaSewa){
        try {
            //register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);

            //menyambungkan ke database
            sambungkan= DriverManager.getConnection(DB_URL,USER,PASS);

            //perintah sqlnya untuk update table
            String sql="UPDATE sewabuku SET tanggal_kembali=? ,denda=? , biaya_sewa=? WHERE id=?";

            //prepared statement untuk update

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
