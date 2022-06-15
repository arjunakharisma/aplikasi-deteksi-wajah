/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppendeteksiwajah;

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;
import static org.opencv.objdetect.Objdetect.CASCADE_SCALE_IMAGE;
import org.opencv.videoio.VideoCapture;

public class AppPendeteksiWajah extends javax.swing.JFrame {

    private Image background;
    String source = "C:\\JavaCV\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml";
    CascadeClassifier faceDetector  = new CascadeClassifier(source);
    
    public AppPendeteksiWajah() {
        initComponents();
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();
        btnPilihfoto = new javax.swing.JButton();
        btnDeteksiFoto = new javax.swing.JButton();
        btnDeteksiKamera = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblNo = new javax.swing.JLabel();
        pnFoto = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Path");

        btnPilihfoto.setText("Pilih Foto");
        btnPilihfoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihfotoActionPerformed(evt);
            }
        });

        btnDeteksiFoto.setText("Deteksi foto");
        btnDeteksiFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeteksiFotoActionPerformed(evt);
            }
        });

        btnDeteksiKamera.setText("Deteksi Kamera");
        btnDeteksiKamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeteksiKameraActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Jumlah Wajah : ");

        lblNo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNo.setText("No");

        pnFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnFotoLayout = new javax.swing.GroupLayout(pnFoto);
        pnFoto.setLayout(pnFotoLayout);
        pnFotoLayout.setHorizontalGroup(
            pnFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnFotoLayout.setVerticalGroup(
            pnFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNo)
                .addGap(0, 111, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPath)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnPilihfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDeteksiKamera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeteksiFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPilihfoto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeteksiFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeteksiKamera, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblNo))
                .addGap(18, 18, 18)
                .addComponent(pnFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(416, 480));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeteksiKameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeteksiKameraActionPerformed
        
        (new Thread(){
            public void run(){
                VideoCapture capture = new VideoCapture(0);
                
                MatOfRect rostros = new MatOfRect();
                MatOfByte mem = new MatOfByte();
                
                Mat frame = new Mat();
                Mat frame_gray = new Mat();
                
                Rect[] facesArray;
                Graphics g;
                BufferedImage buff = null;
                
                while(capture.read(frame)){
                    if(frame.empty()){
                        System.out.println("No detection");
                        break;
                    } else {
                        try {
                            g = pnFoto.getGraphics();
                            Imgproc.cvtColor(frame, frame_gray, Imgproc.COLOR_BGR2GRAY);
                            Imgproc.equalizeHist(frame_gray, frame_gray);
                            double w = frame.width();
                            double h = frame.height();
                            faceDetector.detectMultiScale(frame_gray, rostros, 1.1, 2, 0|CASCADE_SCALE_IMAGE, new Size(30, 30), new Size(w, h));
                            facesArray = rostros.toArray();
                            System.out.println("No of faces: " + facesArray.length);
                            
                            for(int i=0; i<facesArray.length; i++){
                                Point center = new Point((facesArray[i].x + facesArray[i].width * 0.5),
                                (facesArray[i].y + facesArray[i].height * 0.5));
                                Imgproc.ellipse(frame, center, new Size(facesArray[i].width * 0.5, facesArray[i].height * 0.5),
                                    0, 0, 360, new Scalar(255, 0, 255), 4, 8, 0);
                            
                                Mat faceROI = frame_gray.submat(facesArray[i]);
                                Imgproc.rectangle(frame, 
                                    new Point(facesArray[i].x, facesArray[i].y),
                                    new Point(facesArray[i].x + facesArray[i].width, facesArray[i].y + facesArray[i].height),
                                    new Scalar(123, 213, 23, 220));
                                Imgproc.putText(frame, "Width: "+faceROI.width()+" Height: "+faceROI.height()+" X = "+ facesArray[i].x+" Y = "+facesArray[i].y, new Point (facesArray[i].x, facesArray[i].y-20), 1, 1, new Scalar(255,255,255));
                            }
                            
                            int no  = facesArray.length;
                            lblNo.setText(String.valueOf(no));
                            
                            Imgcodecs.imencode(".bmp", frame, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                            buff = (BufferedImage) im;
                            if(g.drawImage(buff, 0, 0, pnFoto.getWidth(), pnFoto.getHeight(), 0, 0, buff.getWidth(), buff.getHeight(), null)){
                                
                            }
                        } catch (Exception ex) {
                            
                        }
                    }
                }
            }
        }).start();
    }//GEN-LAST:event_btnDeteksiKameraActionPerformed

    private void btnPilihfotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihfotoActionPerformed
        JFileChooser fchooser = new JFileChooser();
        fchooser.showOpenDialog(null);
        File f = fchooser.getSelectedFile();
        txtPath.setText(f.getAbsolutePath());
    }//GEN-LAST:event_btnPilihfotoActionPerformed

    private void btnDeteksiFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeteksiFotoActionPerformed
        
	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat image = Imgcodecs.imread(txtPath.getText());
        
        detectAndSave(image);
       
    }//GEN-LAST:event_btnDeteksiFotoActionPerformed

    private void detectAndSave(Mat image){
        MatOfRect faces = new MatOfRect();
        
        Mat grayFrame = new Mat();
        Imgproc.cvtColor(image, grayFrame, Imgproc.COLOR_BGR2GRAY);
        
        Imgproc.equalizeHist(grayFrame, grayFrame);
        
        int height = grayFrame.height();
        int absoluteFaceSize = 0;
        if(Math.round(height * 0.2f) > 0){
            absoluteFaceSize = Math.round(height * 0.2f);
        }
        
        CascadeClassifier faceCascade = new CascadeClassifier();
        
        faceCascade.load("C:\\JavaCV\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt2.xml");
        faceCascade.detectMultiScale(grayFrame, faces, 1.1, 2, 0|Objdetect.CASCADE_SCALE_IMAGE,
                new Size(absoluteFaceSize, absoluteFaceSize), new Size());
        
        Rect[] faceArray = faces.toArray();
        
        for(int i = 0; i< faceArray.length; i++){
            Imgproc.rectangle(image, faceArray[i], new Scalar(0,0,255), 3);
        }
        
        Imgcodecs.imwrite("C:\\Users\\Arjuna\\Pictures\\javacv\\output.jpg", image);
        
        int no  = faceArray.length;
        lblNo.setText(String.valueOf(no));
        
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\Arjuna\\Pictures\\javacv\\output.jpg").getImage().getScaledInstance(385, 255, Image.SCALE_DEFAULT));
        lblFoto.setIcon(imageIcon);
         
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppPendeteksiWajah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppPendeteksiWajah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppPendeteksiWajah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppPendeteksiWajah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppPendeteksiWajah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeteksiFoto;
    private javax.swing.JButton btnDeteksiKamera;
    private javax.swing.JButton btnPilihfoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNo;
    private javax.swing.JPanel pnFoto;
    private javax.swing.JTextField txtPath;
    // End of variables declaration//GEN-END:variables
}
