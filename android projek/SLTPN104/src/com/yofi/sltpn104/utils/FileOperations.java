package com.yofi.sltpn104.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.util.Log;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.yofi.sltpn104.model.AbsensiModel;
import com.yofi.sltpn104.model.GuruModel;
import com.yofi.sltpn104.model.KelasModel;
import com.yofi.sltpn104.model.NilaiModel;
import com.yofi.sltpn104.model.PelajaranModel;
import com.yofi.sltpn104.model.SiswaModel;

public class FileOperations {
    public FileOperations() {
    	
    }
    
    Calendar c = Calendar.getInstance();
    @SuppressLint("SimpleDateFormat")
	SimpleDateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
    String formattedDate = df.format(c.getTime());
    
    public static boolean createDirIfNotExists(String path) {
        boolean ret = true;

        File file = new File(Environment.getExternalStorageDirectory(), path);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                Log.e("TravellerLog :: ", "gagal membuat folder SLTPN");
                ret = false;
            }
        }
        return ret;
    }

    @SuppressLint("SdCardPath")
	public Boolean writeSiswa(String fname, List<SiswaModel> lisSiswaModels) {
        try {
        	createDirIfNotExists("SLTPN");
            String fpath = "/sdcard/SLTPN/" + fname + ".pdf";
            File file = new File(fpath);
            // If file does not exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // step 1
            Document document = new Document();
            // step 2
            PdfWriter.getInstance(document,
                    new FileOutputStream(file.getAbsoluteFile()));
            // step 3
            document.open();
            // step 4
            document.add(new Paragraph("Laporan Data "+fname));
            document.add(new Paragraph("Tanggal: "+formattedDate));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            
            final PdfPTable table = new PdfPTable(10); // 3 columns.
            
            table.addCell("NIS");
            table.addCell("Kode Kelas");
            table.addCell("Nama Lengkap");
            table.addCell("ALamat");
            table.addCell("TTL");
            table.addCell("Tempat Lahir");
            table.addCell("Jenis Kelamin");
            table.addCell("Agama");
            table.addCell("Telpon");
            table.addCell("Kelas");
            
            for (int i = 0; i < lisSiswaModels.size(); i++) {
				SiswaModel siswaModel = lisSiswaModels.get(i);
				table.addCell(siswaModel.getNis());
				table.addCell(siswaModel.getKd_kls());
				table.addCell(siswaModel.getNm_siswa());
				table.addCell(siswaModel.getAlmt_siswa());
				table.addCell(siswaModel.getTgl_lhr_siswa());
				table.addCell(siswaModel.getTemp_lhr_siswa());
				table.addCell(siswaModel.getJns_klmn_siswa());
				table.addCell(siswaModel.getAgm_siswa());
				table.addCell(siswaModel.getTlp_siswa());
				table.addCell(siswaModel.getKls());
				
			}
            document.add(table);
            document.close();

            Log.d("Suceess", "Sucess");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (DocumentException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @SuppressLint("SdCardPath")
	public Boolean writeGuru(String fname, List<GuruModel> lisModels) {
        try {
        	createDirIfNotExists("SLTPN");
            String fpath = "/sdcard/SLTPN/" + fname + ".pdf";
            File file = new File(fpath);
            // If file does not exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // step 1
            Document document = new Document();
            // step 2
            PdfWriter.getInstance(document,
                    new FileOutputStream(file.getAbsoluteFile()));
            // step 3
            document.open();
            // step 4
            document.add(new Paragraph("Laporan Data "+fname));
            document.add(new Paragraph("Tanggal: "+formattedDate));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            
            final PdfPTable table = new PdfPTable(11);
            
            table.addCell("NIP");
            table.addCell("Nama");
            table.addCell("Jenis Kelamin");
            table.addCell("Tempat Lahir");
            table.addCell("TTL");
            table.addCell("Alamat");
            table.addCell("Agama");
            table.addCell("Status Pegawai");
            table.addCell("tahun Masuk");
            table.addCell("Tugas Mengajar");
            table.addCell("Telpon");
            
            for (int i = 0; i < lisModels.size(); i++) {
				GuruModel model = lisModels.get(i);
				table.addCell(model.getNip());
				table.addCell(model.getNm_guru());
				table.addCell(model.getJns_klmn_guru());
				table.addCell(model.getTemp_lhr_guru());
				table.addCell(model.getTgl_lhr_guru());
				table.addCell(model.getAlmt_guru());
				table.addCell(model.getAgm_guru());
				table.addCell(model.getStatus_peg());
				table.addCell(model.getThn_masuk());
				table.addCell(model.getTgs_mgjr_mp());
				table.addCell(model.getTlp_guru());
				
			}
            document.add(table);
            document.close();

            Log.d("Suceess", "Sucess");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (DocumentException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @SuppressLint("SdCardPath")
	public Boolean writePelajaran(String fname, List<PelajaranModel> lisModels) {
        try {
        	createDirIfNotExists("SLTPN");
            String fpath = "/sdcard/SLTPN/" + fname + ".pdf";
            File file = new File(fpath);
            // If file does not exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // step 1
            Document document = new Document();
            // step 2
            PdfWriter.getInstance(document,
                    new FileOutputStream(file.getAbsoluteFile()));
            // step 3
            document.open();
            // step 4
            document.add(new Paragraph("Laporan Data "+fname));
            document.add(new Paragraph("Tanggal: "+formattedDate));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            
            final PdfPTable table = new PdfPTable(6);
            
            table.addCell("Kode");
            table.addCell("Nama");
            table.addCell("Hari");
            table.addCell("Jam");
            table.addCell("Kelas");
            table.addCell("Semester");
            
            
            for (int i = 0; i < lisModels.size(); i++) {
				PelajaranModel model = lisModels.get(i);
				table.addCell(model.getKd_pel());
				table.addCell(model.getNm_pel());
				table.addCell(model.getHari());
				table.addCell(model.getJam());
				table.addCell(model.getKls());
				table.addCell(model.getSemester());
				
				
			}
            document.add(table);
            document.close();

            Log.d("Suceess", "Sucess");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (DocumentException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @SuppressLint("SdCardPath")
	public Boolean writeNilai(String fname, List<NilaiModel> lisModels) {
        try {
        	createDirIfNotExists("SLTPN");
            String fpath = "/sdcard/SLTPN/" + fname + ".pdf";
            File file = new File(fpath);
            // If file does not exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // step 1
            Document document = new Document();
            // step 2
            PdfWriter.getInstance(document,
                    new FileOutputStream(file.getAbsoluteFile()));
            // step 3
            document.open();
            // step 4
            document.add(new Paragraph("Laporan Data "+fname));
            document.add(new Paragraph("Tanggal: "+formattedDate));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            
            final PdfPTable table = new PdfPTable(7);
            
            table.addCell("KODE");
            table.addCell("NIP");
            table.addCell("NIS");
            table.addCell("Nama Siswa");
            table.addCell("KODE Kelas");
            table.addCell("Nilai");
            table.addCell("KET");
            
            
            for (int i = 0; i < lisModels.size(); i++) {
				NilaiModel model = lisModels.get(i);
				table.addCell(model.getKd_pel());
				table.addCell(model.getNip());
				table.addCell(model.getNis());
				table.addCell(model.getNm_siswa());
				table.addCell(model.getKd_kls());
				table.addCell(model.getNilai());
				table.addCell(model.getKet());
				
				
			}
            document.add(table);
            document.close();

            Log.d("Suceess", "Sucess");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (DocumentException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @SuppressLint("SdCardPath")
	public Boolean writeAbsensi(String fname, List<AbsensiModel> lisModels) {
        try {
        	createDirIfNotExists("SLTPN");
            String fpath = "/sdcard/SLTPN/" + fname + ".pdf";
            File file = new File(fpath);
            // If file does not exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // step 1
            Document document = new Document();
            // step 2
            PdfWriter.getInstance(document,
                    new FileOutputStream(file.getAbsoluteFile()));
            // step 3
            document.open();
            // step 4
            document.add(new Paragraph("Laporan Data "+fname));
            document.add(new Paragraph("Tanggal: "+formattedDate));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            
            final PdfPTable table = new PdfPTable(6);
            
            table.addCell("ID");
            table.addCell("Tanggal Masuk");
            table.addCell("Jam Masuk");
            table.addCell("Jam Keluar");
            table.addCell("Status");
            table.addCell("KET");
            
            
            for (int i = 0; i < lisModels.size(); i++) {
				AbsensiModel model = lisModels.get(i);
				table.addCell(model.getId_absen());
				table.addCell(model.getTgl_msk());
				table.addCell(model.getJam_msk());
				table.addCell(model.getJam_klr());
				table.addCell(model.getStatus());
				table.addCell(model.getKet_absen());
				
			}
            document.add(table);
            document.close();

            Log.d("Suceess", "Sucess");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (DocumentException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @SuppressLint("SdCardPath")
	public Boolean writeKelas(String fname, List<KelasModel> lisModels) {
        try {
        	createDirIfNotExists("SLTPN");
            String fpath = "/sdcard/SLTPN/" + fname + ".pdf";
            File file = new File(fpath);
            // If file does not exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // step 1
            Document document = new Document();
            // step 2
            PdfWriter.getInstance(document,
                    new FileOutputStream(file.getAbsoluteFile()));
            // step 3
            document.open();
            // step 4
            document.add(new Paragraph("Laporan Data "+fname));
            document.add(new Paragraph("Tanggal: "+formattedDate));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            
            final PdfPTable table = new PdfPTable(3);
            
            table.addCell("KODE");
            table.addCell("NIP");
            table.addCell("Nama Kelas");
            
            
            for (int i = 0; i < lisModels.size(); i++) {
				KelasModel model = lisModels.get(i);
				table.addCell(model.getKd_kls());
				table.addCell(model.getNip());
				table.addCell(model.getNm_kls());
				
				
			}
            document.add(table);
            document.close();

            Log.d("Suceess", "Sucess");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (DocumentException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}