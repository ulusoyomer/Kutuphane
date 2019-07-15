/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Front;

import Back.BooksInfo;
import Back.MembersInfo;
import Back.TranInfo;
import Back.Works;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author qq
 */
public class Window extends javax.swing.JDialog{
    private Works works = new Works();
    private static final TableCellRenderer render = new DefaultTableCellRenderer();
    DefaultTableModel tableModel_members,tableModel_books,tableModel_tran = null;
    ArrayList<MembersInfo> membersInfos = new ArrayList<MembersInfo>();
    ArrayList<BooksInfo> booksInfos = new ArrayList<BooksInfo>();
    ArrayList<TranInfo> tranInfos = new ArrayList<TranInfo>();
    Keys keys = new Keys();
    int member_id = -1 ;
    int book_id = -1;
    int tran_id = -1;
    public Window(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setDimension();
        jPanel2.setFocusable(true);
        tableModel_members = (DefaultTableModel)table_members.getModel();
        tableModel_books = (DefaultTableModel)table_books.getModel();
        tableModel_tran = (DefaultTableModel)table_tran.getModel();
        button_books.setText("Kitaplar");
        button_members.setText("Üyeler");
        button_tran.setText("Alınmış Kitaplar");
        table_members.setVisible(false);
        scroll_members.setVisible(false);
        table_tran.setVisible(false);
        scroll_tran.setVisible(false);
        box_member_name.addKeyListener(keys);
        box_member_surname.addKeyListener(keys);
        box_member_id.addKeyListener(keys);
        box_member_tel.addKeyListener(keys);
        getAllMembers();
        getAllBooks();
        getAllTran();
    }
    public void getAllMembers(){
        tableModel_members.setRowCount(0);
        membersInfos = works.getMemebers();
        if(membersInfos != null){
            for(int i = 0 ; i<membersInfos.size();i++){
                Object[] eklenecek = {membersInfos.get(i).getId(),membersInfos.get(i).getName(),membersInfos.get(i).getSurname(),
                    membersInfos.get(i).getRegDate(),membersInfos.get(i).getTcno(),membersInfos.get(i).getTel()
                };
                tableModel_members.addRow(eklenecek);
            }
        }
    }
    public void getAllBooks(){
        tableModel_books.setRowCount(0);
        booksInfos = works.getBooks();
        if(booksInfos != null){
            for(BooksInfo booksInfo : booksInfos){
                Object[] eklenecek ={
                    booksInfo.getId(),booksInfo.getName(),booksInfo.getWriter(),booksInfo.getYear(),
                    booksInfo.getPublisher(),booksInfo.getPage(),booksInfo.getBType()
                };
                tableModel_books.addRow(eklenecek);
            }
        }
        
    }
    public void getAllTran(){
        tableModel_tran.setRowCount(0);
        tranInfos = works.getTranInfos();
        if(tranInfos != null){
            for(TranInfo tranInfo : tranInfos){
                Object [] eklenecek ={
                   tranInfo.getId(), tranInfo.getUsername(),tranInfo.getBookname(),tranInfo.getGudate(),tranInfo.getGbdate(),
                    
                };
                tableModel_tran.addRow(eklenecek);
            }
        }
        control();
    }
   public void control(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0; i<table_tran.getRowCount(); i++){
            try {
                Date date = formatter.parse(tableModel_tran.getValueAt(i, 4).toString());
                Date today = Calendar.getInstance().getTime();
                if(today.compareTo(date) > 0){
                    Object past = "süre dolmuş";
                    tableModel_tran.setValueAt(past, i, 5);
                }
                else{
                    Object past = "";
                    tableModel_tran.setValueAt(past, i, 5);
                }
            } catch (ParseException ex) {

            }
        }
    } 
 
    public final void setDimension(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width-getWidth())/2, (screen.height-getHeight())/2);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        button_books = new javax.swing.JButton();
        button_tran = new javax.swing.JButton();
        button_members = new javax.swing.JButton();
        scroll_members = new javax.swing.JScrollPane();
        table_members = new javax.swing.JTable();
        scroll_books = new javax.swing.JScrollPane();
        table_books = new javax.swing.JTable();
        scroll_tran = new javax.swing.JScrollPane();
        table_tran = new javax.swing.JTable();
        box_search = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        box_book_name = new javax.swing.JTextField();
        box_book_writer = new javax.swing.JTextField();
        box_book_date = new com.toedter.calendar.JDateChooser();
        box_book_publisher = new javax.swing.JTextField();
        box_book_page = new javax.swing.JTextField();
        box_book_type = new javax.swing.JTextField();
        button_book_update = new javax.swing.JButton();
        button_book_add = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        box_member_name = new javax.swing.JTextField();
        box_member_surname = new javax.swing.JTextField();
        box_member_id = new javax.swing.JTextField();
        button_member_update = new javax.swing.JButton();
        button_member_add = new javax.swing.JButton();
        box_message_member = new javax.swing.JLabel();
        box_message_book = new javax.swing.JLabel();
        box_member_tel = new javax.swing.JTextField();
        button_memDelete = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        button_bookDelete = new javax.swing.JButton();
        button_kitapVer = new javax.swing.JButton();
        button_giveBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button_books.setText("Kitaplar");
        button_books.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_booksActionPerformed(evt);
            }
        });
        jPanel1.add(button_books, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 60));

        button_tran.setText("Alınmış Kitaplar");
        button_tran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tranActionPerformed(evt);
            }
        });
        jPanel1.add(button_tran, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 190, 60));

        button_members.setText("Üyeler");
        button_members.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_membersActionPerformed(evt);
            }
        });
        jPanel1.add(button_members, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 200, 60));

        table_members.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Ad", "Soyad", "Kayıt Tarihi", "TcNo", "Telefon"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_members.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_membersMouseClicked(evt);
            }
        });
        scroll_members.setViewportView(table_members);
        if (table_members.getColumnModel().getColumnCount() > 0) {
            table_members.getColumnModel().getColumn(0).setResizable(false);
            table_members.getColumnModel().getColumn(0).setPreferredWidth(10);
            table_members.getColumnModel().getColumn(1).setResizable(false);
            table_members.getColumnModel().getColumn(2).setResizable(false);
            table_members.getColumnModel().getColumn(3).setResizable(false);
            table_members.getColumnModel().getColumn(4).setResizable(false);
            table_members.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(scroll_members, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 680, 550));

        table_books.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Kitap Adı", "Yazarı", "Basım Yılı", "Kitap Evi", "Sayfa", "Türü"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_books.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_booksMouseClicked(evt);
            }
        });
        scroll_books.setViewportView(table_books);
        if (table_books.getColumnModel().getColumnCount() > 0) {
            table_books.getColumnModel().getColumn(0).setResizable(false);
            table_books.getColumnModel().getColumn(0).setPreferredWidth(10);
            table_books.getColumnModel().getColumn(1).setResizable(false);
            table_books.getColumnModel().getColumn(2).setResizable(false);
            table_books.getColumnModel().getColumn(3).setResizable(false);
            table_books.getColumnModel().getColumn(3).setPreferredWidth(35);
            table_books.getColumnModel().getColumn(4).setResizable(false);
            table_books.getColumnModel().getColumn(5).setResizable(false);
            table_books.getColumnModel().getColumn(5).setPreferredWidth(15);
            table_books.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.add(scroll_books, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 680, 550));

        table_tran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Ad Soyad", "Kitap Adı", "Verilen Tarih", "Alınacak Tarih", "Durum"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_tran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_tranMouseClicked(evt);
            }
        });
        scroll_tran.setViewportView(table_tran);
        if (table_tran.getColumnModel().getColumnCount() > 0) {
            table_tran.getColumnModel().getColumn(0).setResizable(false);
            table_tran.getColumnModel().getColumn(0).setPreferredWidth(10);
            table_tran.getColumnModel().getColumn(1).setResizable(false);
            table_tran.getColumnModel().getColumn(2).setResizable(false);
            table_tran.getColumnModel().getColumn(3).setResizable(false);
            table_tran.getColumnModel().getColumn(4).setResizable(false);
            table_tran.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(scroll_tran, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 680, 550));

        box_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                box_searchKeyReleased(evt);
            }
        });
        jPanel1.add(box_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 680, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Yeni Kitap Ekle / Kitap Güncelleme");

        box_book_name.setForeground(new java.awt.Color(204, 204, 204));
        box_book_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box_book_name.setText("Kitap Adı");
        box_book_name.setPreferredSize(new java.awt.Dimension(49, 20));
        box_book_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box_book_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box_book_nameFocusLost(evt);
            }
        });

        box_book_writer.setForeground(new java.awt.Color(204, 204, 204));
        box_book_writer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box_book_writer.setText("Yazar");
        box_book_writer.setPreferredSize(new java.awt.Dimension(49, 20));
        box_book_writer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box_book_writerFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box_book_writerFocusLost(evt);
            }
        });

        box_book_date.setDateFormatString("yyyy-MM-dd");
        box_book_date.setPreferredSize(new java.awt.Dimension(49, 20));

        box_book_publisher.setForeground(new java.awt.Color(204, 204, 204));
        box_book_publisher.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box_book_publisher.setText("Kitap Evi");
        box_book_publisher.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box_book_publisherFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box_book_publisherFocusLost(evt);
            }
        });

        box_book_page.setForeground(new java.awt.Color(204, 204, 204));
        box_book_page.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box_book_page.setText("Sayfa Sayısı");
        box_book_page.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box_book_pageFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box_book_pageFocusLost(evt);
            }
        });

        box_book_type.setForeground(new java.awt.Color(204, 204, 204));
        box_book_type.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box_book_type.setText("Türü");
        box_book_type.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box_book_typeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box_book_typeFocusLost(evt);
            }
        });

        button_book_update.setText("Güncelle");
        button_book_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_book_updateActionPerformed(evt);
            }
        });

        button_book_add.setText("Ekle");
        button_book_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_book_addActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Yeni Üye Kaydı/ Üye Güncelleme");

        box_member_name.setForeground(new java.awt.Color(204, 204, 204));
        box_member_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box_member_name.setText("İsim");
        box_member_name.setPreferredSize(new java.awt.Dimension(49, 20));
        box_member_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box_member_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box_member_nameFocusLost(evt);
            }
        });

        box_member_surname.setForeground(new java.awt.Color(204, 204, 204));
        box_member_surname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box_member_surname.setText("Soyisim");
        box_member_surname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box_member_surnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box_member_surnameFocusLost(evt);
            }
        });

        box_member_id.setForeground(new java.awt.Color(204, 204, 204));
        box_member_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box_member_id.setText("Tc No");
        box_member_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box_member_idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box_member_idFocusLost(evt);
            }
        });

        button_member_update.setText("Güncelle");
        button_member_update.setPreferredSize(new java.awt.Dimension(105, 23));
        button_member_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_member_updateActionPerformed(evt);
            }
        });

        button_member_add.setText("Ekle");
        button_member_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_member_addActionPerformed(evt);
            }
        });

        box_message_member.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        box_message_member.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        box_message_book.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        box_message_book.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        box_member_tel.setForeground(new java.awt.Color(204, 204, 204));
        box_member_tel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box_member_tel.setText("Tel No");
        box_member_tel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box_member_telFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box_member_telFocusLost(evt);
            }
        });

        button_memDelete.setText("Sil");
        button_memDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_memDeleteActionPerformed(evt);
            }
        });

        button_bookDelete.setText("Sil");
        button_bookDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_bookDeleteActionPerformed(evt);
            }
        });

        button_kitapVer.setText("Kitap Ver");
        button_kitapVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_kitapVerActionPerformed(evt);
            }
        });

        button_giveBack.setText("Geri Al");
        button_giveBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_giveBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator3)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(box_book_name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(button_memDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(button_member_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button_kitapVer, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(box_book_publisher, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(box_book_page, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_book_update, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(button_giveBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(box_book_type)
                                        .addComponent(button_book_add, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(box_book_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(box_book_writer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(box_member_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                .addComponent(box_member_surname, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(box_member_id, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(box_member_tel, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(button_member_update, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(box_message_book, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box_message_member, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_bookDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(box_book_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(box_book_writer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(box_book_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(box_book_publisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box_book_page, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_book_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_book_update)
                    .addComponent(button_book_add))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_bookDelete)
                    .addComponent(button_giveBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(box_message_book, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(box_member_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(box_member_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(box_member_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(box_member_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button_member_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_member_add, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_memDelete)
                    .addComponent(button_kitapVer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(box_message_member, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 11, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_booksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_booksActionPerformed
        table_members.setVisible(false);
        scroll_members.setVisible(false);
        table_tran.setVisible(false);
        scroll_tran.setVisible(false);
        scroll_books.setVisible(true);
        table_books.setVisible(true);
        getAllBooks();
    }//GEN-LAST:event_button_booksActionPerformed

    private void button_membersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_membersActionPerformed
        table_tran.setVisible(false);
        scroll_tran.setVisible(false);
        scroll_books.setVisible(false);
        table_books.setVisible(false);
        scroll_members.setVisible(true);
        table_members.setVisible(true);
        getAllMembers();
    }//GEN-LAST:event_button_membersActionPerformed

    private void button_tranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tranActionPerformed
        scroll_books.setVisible(false);
        table_books.setVisible(false);
        table_members.setVisible(false);
        scroll_members.setVisible(false);
        scroll_tran.setVisible(true);
        table_tran.setVisible(true);
        getAllTran();
        
    }//GEN-LAST:event_button_tranActionPerformed

    private void box_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_box_searchKeyReleased
        String search = box_search.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> sort_member = new TableRowSorter<DefaultTableModel>(tableModel_members);
        table_members.setRowSorter(sort_member);
        sort_member.setRowFilter(RowFilter.regexFilter(search));
        TableRowSorter<DefaultTableModel> sort_books = new TableRowSorter<DefaultTableModel>(tableModel_books);
        table_books.setRowSorter(sort_books);
        sort_books.setRowFilter(RowFilter.regexFilter(search));
        TableRowSorter<DefaultTableModel> sort_tran = new TableRowSorter<DefaultTableModel>(tableModel_tran);
        table_tran.setRowSorter(sort_tran);
        sort_tran.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_box_searchKeyReleased

    private void table_membersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_membersMouseClicked
        int selected_row = table_members.getSelectedRow();
        box_member_name.setForeground(Color.black);
        box_member_name.setText(tableModel_members.getValueAt(selected_row, 1).toString());
        box_member_surname.setForeground(Color.black);
        box_member_surname.setText(tableModel_members.getValueAt(selected_row, 2).toString());
        box_member_id.setForeground(Color.black);
        box_member_id.setText(tableModel_members.getValueAt(selected_row, 4).toString());
        box_member_tel.setForeground(Color.black);
        box_member_tel.setText(tableModel_members.getValueAt(selected_row, 5).toString());
        member_id = Integer.parseInt(table_members.getValueAt(selected_row, 0).toString());
        trueMem("Üye Seçildi");  
    }//GEN-LAST:event_table_membersMouseClicked

    private void box_member_telFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_member_telFocusLost
        if(box_member_tel.equals("")){
            box_member_tel.setText("Tel No");
            box_member_tel.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_box_member_telFocusLost

    private void box_member_telFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_member_telFocusGained
        if(box_member_tel.equals("Tel No")){
            box_member_tel.setText("");
            box_member_tel.setForeground(Color.black);
        }
    }//GEN-LAST:event_box_member_telFocusGained

    private void button_member_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_member_addActionPerformed
        String name = box_member_name.getText();
        String surname = box_member_surname.getText();
        String tel = box_member_tel.getText();
        long id;
        if(box_member_id.getText().length() == 11){
            id = Long.parseLong(box_member_id.getText());
            if(!name.equals("İsim") && !surname.equals("Soyisim") && !tel.equals("Tel No")){
                if(works.addMember(name, surname, id,tel)){
                    trueMem("Üye Kaydı Başarılı");
                    getAllMembers();
                }
                else{
                    wrongMem("Tc no kayıtlıdır.");
                }
            }else{
                wrongMem("Gerekli Alanlar Boş"); 
            }
        }
        else{
            wrongMem("Tc No Eksik");
        }
    }//GEN-LAST:event_button_member_addActionPerformed

    private void box_member_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_member_idFocusLost
        if(box_member_id.getText().equals("")){
            box_member_id.setText("Tc No");
            box_member_id.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_box_member_idFocusLost

    private void box_member_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_member_idFocusGained
        if(box_member_id.getText().equals("Tc No")){
            box_member_id.setText("");
            box_member_id.setForeground(Color.black);
        }
    }//GEN-LAST:event_box_member_idFocusGained

    private void box_member_surnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_member_surnameFocusLost
        if(box_member_surname.getText().equals("")){
            box_member_surname.setText("Soyisim");
            box_member_surname.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_box_member_surnameFocusLost

    private void box_member_surnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_member_surnameFocusGained
        if(box_member_surname.getText().equals("Soyisim")){
            box_member_surname.setText("");
            box_member_surname.setForeground(Color.black);
        }
    }//GEN-LAST:event_box_member_surnameFocusGained

    private void box_member_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_member_nameFocusLost
        if(box_member_name.getText().equals("")){
            box_member_name.setText("İsim");
            box_member_name.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_box_member_nameFocusLost

    private void box_member_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_member_nameFocusGained
        if(box_member_name.getText().equals("İsim")){
            box_member_name.setText("");
            box_member_name.setForeground(Color.black);
        }
    }//GEN-LAST:event_box_member_nameFocusGained

    private void button_book_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_book_addActionPerformed
        Date date1 = box_book_date.getDate();
        if(date1 != null){
            java.sql.Date date = new java.sql.Date(date1.getTime());
            String name = box_book_name.getText();
            String writer = box_book_writer.getText();
            String publisher = box_book_publisher.getText();
            String type = box_book_type.getText();
            int page;
            try {
                page = Integer.parseInt(box_book_page.getText());
            } catch (NumberFormatException e) {
                page = -1;
            }
            if(!name.equals("Kitap Adı") && !writer.equals("Yazar") && !publisher.equals("Kitap Evi") && page != -1 && !type.equals("Türü")){
                if(works.addBook(name, writer,date, publisher, type, page)){
                    trueBook("Kitap Eklendi");
                    getAllBooks();
                }
                else{
                    wrongBook("Kitap Eklenmedi");
                    
                }
            }else{
                wrongBook("Alanları Düzgün Bir Şekilde Doldurunuz");
            }
        }
        else{
            wrongBook("Alanları Düzgün Bir Şekilde Doldurunuz");
        }
    }//GEN-LAST:event_button_book_addActionPerformed

    private void box_book_typeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_book_typeFocusLost
        if(box_book_type.getText().equals("")){
            box_book_type.setText("Türü");
            box_book_type.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_box_book_typeFocusLost

    private void box_book_typeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_book_typeFocusGained
        if(box_book_type.getText().equals("Türü")){
            box_book_type.setText("");
            box_book_type.setForeground(Color.black);
        }
    }//GEN-LAST:event_box_book_typeFocusGained

    private void box_book_pageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_book_pageFocusLost
        if(box_book_page.getText().equals("")){
            box_book_page.setText("Sayfa Sayısı");
            box_book_page.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_box_book_pageFocusLost

    private void box_book_pageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_book_pageFocusGained
        if(box_book_page.getText().equals("Sayfa Sayısı")){
            box_book_page.setText("");
            box_book_page.setForeground(Color.black);
        }
    }//GEN-LAST:event_box_book_pageFocusGained

    private void box_book_publisherFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_book_publisherFocusLost
        if(box_book_publisher.getText().equals("")){
            box_book_publisher.setText("Kitap Evi");
            box_book_publisher.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_box_book_publisherFocusLost

    private void box_book_publisherFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_book_publisherFocusGained
        if(box_book_publisher.getText().equals("Kitap Evi")){
            box_book_publisher.setText("");
            box_book_publisher.setForeground(Color.black);
        }
    }//GEN-LAST:event_box_book_publisherFocusGained

    private void box_book_writerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_book_writerFocusLost
        if(box_book_writer.getText().equals("")){
            box_book_writer.setText("Yazar");
            box_book_writer.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_box_book_writerFocusLost

    private void box_book_writerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_book_writerFocusGained
        if(box_book_writer.getText().equals("Yazar")){
            box_book_writer.setText("");
            box_book_writer.setForeground(Color.black);
        }
    }//GEN-LAST:event_box_book_writerFocusGained

    private void box_book_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_book_nameFocusLost
        if(box_book_name.getText().equals("")){
            box_book_name.setText("Kitap Adı");
            box_book_name.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_box_book_nameFocusLost

    private void box_book_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box_book_nameFocusGained
        if(box_book_name.getText().equals("Kitap Adı")){
            box_book_name.setText("");
            box_book_name.setForeground(Color.black);
        }
    }//GEN-LAST:event_box_book_nameFocusGained

    private void button_member_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_member_updateActionPerformed
        if(member_id == -1){
            wrongMem("Tc no Bulunamadı");  
        }
        else{
        String name = box_member_name.getText();
        String surname = box_member_surname.getText();
        long tcno = Long.parseLong(box_member_id.getText());
        String tel = box_member_tel.getText();
        if(!name.equals("İsim") || !surname.equals("Soyisim") || !tel.equals("Tel No")){
            if(works.updateMember(name, surname, tcno, tel, member_id)){
                trueMem("Güncelleme Başarılı");
            member_id = -1;
            getAllMembers();
        }
        else{
            wrongMem("Güncelleme Başarısız");
            member_id = -1;
        }
        }else{
            wrongMem("Gerekli Alanlar Boş");
            member_id = -1;
        }
        
        }
        
        
    }//GEN-LAST:event_button_member_updateActionPerformed

    private void table_booksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_booksMouseClicked
        int selected_row = table_books.getSelectedRow();
        book_id = Integer.parseInt(tableModel_books.getValueAt(selected_row, 0).toString());
        box_book_name.setForeground(Color.black);
        box_book_name.setText(tableModel_books.getValueAt(selected_row, 1).toString());
        box_book_writer.setForeground(Color.black);
        box_book_writer.setText(tableModel_books.getValueAt(selected_row, 2).toString());
        java.sql.Date date = java.sql.Date.valueOf(tableModel_books.getValueAt(selected_row, 3).toString());
        box_book_date.setDate(date);
        box_book_publisher.setForeground(Color.black);
        box_book_publisher.setText(tableModel_books.getValueAt(selected_row, 4).toString());
        box_book_page.setForeground(Color.black);
        box_book_page.setText(tableModel_books.getValueAt(selected_row, 5).toString());
        box_book_type.setForeground(Color.black);
        box_book_type.setText(tableModel_books.getValueAt(selected_row, 6).toString());
        trueBook("Kitap Seçildi");
        
    }//GEN-LAST:event_table_booksMouseClicked

    private void button_book_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_book_updateActionPerformed
        if(book_id != -1){
            if(!box_book_name.getText().equals("Kitap Adı") || !box_book_publisher.getText().equals("Kitap Evi") || !box_book_writer.getText().equals("Yazar")
                    || !box_book_page.getText().equals("Sayfa Sayısı") || !box_book_type.getText().equals("Türü")){
                Date date1 = box_book_date.getDate();
                if(date1 != null){
                    java.sql.Date date = new java.sql.Date(date1.getTime());
                    String book_name = box_book_name.getText();
                    String writer = box_book_writer.getText();
                    String publisher = box_book_publisher.getText();
                    int page = Integer.parseInt(box_book_page.getText());
                    String type = box_book_type.getText();
                    if(works.updateBooks(book_id,book_name,writer,date,publisher,page,type)){
                        trueBook("Güncelleme Başarılı");
                    }
                    else{
                        wrongBook("Güncelleme Başarısız");
                    }
                }
                
                
            }
        }
        getAllBooks();
        book_id = -1;
    }//GEN-LAST:event_button_book_updateActionPerformed

    private void button_kitapVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_kitapVerActionPerformed
        if(member_id != -1 || book_id != -1){
          String value =  JOptionPane.showInputDialog(this, "Geri alınacak Günü Giriniz (Yıl-Ay-Gün) Örn 2018-05-20 ");
                if(!value.equals("")){
                    try {
                    java.sql.Date date = java.sql.Date.valueOf(value);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String today = simpleDateFormat.format(Calendar.getInstance().getTime());
                    java.sql.Date toDate = java.sql.Date.valueOf(today);
                    if(date.compareTo(toDate) > 0){
                        if(works.addTran(member_id, book_id, date)){
                            trueMem("Kitap Verme İşlemi tamam");
                            trueBook("Kitap Verme İşlemi tamam");
                        }else{
                            wrongMem("Kitap Verme İşlemi tamamlanamadı");
                            wrongBook("Kitap Verme İşlemi tamamlanamadı");
                        }
                    }else{
                         wrongMem("Geçmiş Tarih Girilmez");
                         wrongBook("Geçmiş Tarih Girilmez");
                    }
                    } catch (Exception e) {
                         wrongMem("Uygun Olmayan Karakter Girdiniz");
                         wrongBook("Uygun Olmayan Karakter Girdiniz");
                    }

              }else{
              wrongMem("Günü Boş Bırakamazsınız");
              wrongBook("Günü Boş Bırakamazsınız");
          }

          }
        else{
            wrongMem("Kitap ve Kullanıcı Seçmelisiniz");
            wrongBook("Kitap ve Kullanıcı Seçmelisiniz");
              }
          
    }//GEN-LAST:event_button_kitapVerActionPerformed

    private void button_giveBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_giveBackActionPerformed
        if(tran_id != -1){
            if(works.deleteTran(tran_id)){
                trueBook("Kitap Kütüphaneye Geri Koyuldu");
                trueMem("Kitap Kütüphaneye Geri Koyuldu");
            }
            else{
                wrongBook("Geri Alınma İşlemi Başarısız");
                wrongMem("Geri Alınma İşlemi Başarısız");
            }
        }
        tran_id = -1;
        getAllTran();
    }//GEN-LAST:event_button_giveBackActionPerformed

    private void table_tranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_tranMouseClicked
        int selected_row = table_tran.getSelectedRow();
        tran_id = Integer.parseInt(tableModel_tran.getValueAt(selected_row, 0).toString());
        trueBook("Alınmış Kitap ve Kullanıcı Seçildi");
        trueMem("Alınmış Kitap ve Kullanıcı Seçildi");
    }//GEN-LAST:event_table_tranMouseClicked

    private void button_memDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_memDeleteActionPerformed
        if(member_id != -1){
            if(works.deleteMem(member_id)){
                trueMem("Kullanıcı Silindi");
                getAllMembers();
            }
            else{
                wrongMem("Kullanıcı Silinemedi");
            }
        }
        else{
            wrongMem("Silmek İçin Üye Seçiniz");
        }
    }//GEN-LAST:event_button_memDeleteActionPerformed

    private void button_bookDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_bookDeleteActionPerformed
        if(book_id != -1){
            if(works.deleteBook(book_id)){
                trueBook("Kitap Silindi");
                getAllBooks();
            }
            else{
                wrongBook("Kitap Silinemedi");
            }
        }else{
            wrongBook("Silmek için Kitap Seçiniz");
        }
    }//GEN-LAST:event_button_bookDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser box_book_date;
    private javax.swing.JTextField box_book_name;
    private javax.swing.JTextField box_book_page;
    private javax.swing.JTextField box_book_publisher;
    private javax.swing.JTextField box_book_type;
    private javax.swing.JTextField box_book_writer;
    private javax.swing.JTextField box_member_id;
    private javax.swing.JTextField box_member_name;
    private javax.swing.JTextField box_member_surname;
    private javax.swing.JTextField box_member_tel;
    private javax.swing.JLabel box_message_book;
    private javax.swing.JLabel box_message_member;
    private javax.swing.JTextField box_search;
    private javax.swing.JButton button_bookDelete;
    private javax.swing.JButton button_book_add;
    private javax.swing.JButton button_book_update;
    private javax.swing.JButton button_books;
    private javax.swing.JButton button_giveBack;
    private javax.swing.JButton button_kitapVer;
    private javax.swing.JButton button_memDelete;
    private javax.swing.JButton button_member_add;
    private javax.swing.JButton button_member_update;
    private javax.swing.JButton button_members;
    private javax.swing.JButton button_tran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JScrollPane scroll_books;
    private javax.swing.JScrollPane scroll_members;
    private javax.swing.JScrollPane scroll_tran;
    private javax.swing.JTable table_books;
    private javax.swing.JTable table_members;
    private javax.swing.JTable table_tran;
    // End of variables declaration//GEN-END:variables

    public void wrongMem(String s){
        box_message_member.setText("");
        box_message_member.setForeground(Color.red);
        box_message_member.setText(s);
    }
    public void wrongBook(String s){
        box_message_book.setText("");
        box_message_book.setForeground(Color.red);
        box_message_book.setText(s);
    }
    public void trueBook(String s){
        box_message_book.setText("");
        box_message_book.setForeground(Color.green);
        box_message_book.setText(s);
    }
    public void trueMem(String s){
        box_message_member.setText("");
        box_message_member.setForeground(Color.green);
        box_message_member.setText(s);
    }

    class Keys implements KeyListener{
        
        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(!box_member_name.getText().equals("İsim")){
               if(numControl(box_member_name)){
                   wrongMem("Sayı Olmamalıdır");
               }
               else{
                   box_message_member.setText("");
                   
               }
            }
           if(!box_member_surname.getText().equals("Soyisim")){
               if(numControl(box_member_surname)){
                   wrongMem("Sayı Olmamalıdır");
               }
               else{
                   box_message_member.setText("");
               }
           }
           if(!box_member_id.getText().equals("Tc No")){
               String tc = box_member_id.getText();
               int lenght = tc.length();
               if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9'){
                   if(lenght<11){
                       box_member_id.setEditable(true);
                   }else{
                       box_member_id.setEditable(false);
                   }
               }else{
               if(e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE){
                   box_member_id.setEditable(true);
               }else{
                   box_member_id.setEditable(false);
               }
           }
           }
           if(!box_member_tel.getText().equals("Tel No")){
               String tel = box_member_tel.getText();
               int lenght = tel.length();
               if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9'){
                   if(lenght < 11){
                       box_member_tel.setEditable(true);
                   }
                   else{
                       box_member_tel.setEditable(false);
                   }
               }else{
                   if(e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE){
                       box_member_tel.setEditable(true);
                   }
                   else{
                       box_member_tel.setEditable(false);
                   }
               }
           }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        public boolean numControl(JTextField textField){
             try {
                    int i = Integer.parseInt(textField.getText());
                    return true;
                    
                } catch (NumberFormatException e1) {
                    return false;
                }
        }

}
}
