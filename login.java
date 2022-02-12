//ini adalah syntax pada tombol login dimana ketika tombol login  di klik, 
//maka akan melakukan aksi (ActionPerformed) dan mengeksekusi blok kode berikut.


private void loginActionPerformed(java.awt.event.ActionEvent evt) {                                      
    a = new menu_utama();   //melakukan pendeklarasian pada "menu_utama.java" menjadi variabel "a"
  
    //melakukan pengkoneksian ke database "tugasakhir" => tabel "akun" => kolom "id" dan "password"
    //menghubungkan database kolom "id" dengan jtexfield "user" 
    //dan kolom "password" dengan jtextfield "pass"
    try{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tugasakhir","root","");
        ResultSet rs = con.createStatement().executeQuery("select * from akun where id='"+user.getText()+"' and password='"+String.valueOf(pass.getText())+"'"); 
        
    //setelah pengkoneksian (try) diatas berhasil maka akan mengeksekusi kondisi "if"
    //jika pengkoneksian (try) gagal, makan akan mengeksekusi kondisi (catch) dan memunculkan output error
      
   //jika kondisi "if" berhasil dieksekusi dan memasukan ID/PASS dengan benar, maka muncul pesan "LOGIN BERHASIL" => menu login akan hilang => menu_utama akan muncul
   //jika kondisi "if" berhasil dieksekusi dan memasukan ID/PASS yang salah, maka akan mengeksekusi kondisi "else"
   //jika kondisi "else" dieksekusi, maka akan memunculkan pesan "USERNAME ATAU PASSWOD SALAH", lalu value jtextfield "user" dan "pass" akan kosong
        if(rs.next()){
            nama.setText(rs.getString(3));
            nik.setText(rs.getString(2));
           JOptionPane.showMessageDialog(this, "LOGIN BERHASIL");
           a.setVisible(true);
           this.dispose();
         JOptionPane.showMessageDialog(rootPane, "SELAMAT DATANG");
       }else{
           JOptionPane.showMessageDialog(rootPane, "USERNAME ATAU PASSWORD SALAH");
           user.setText("");
           pass.setText("");
       }
    }catch (SQLException ex){
        Logger.getLogger(login.class.getName()).log(Level.SEVERE,null, ex);
    }
    }             
