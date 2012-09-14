package com.bissy.distrib.bookstore.client;

import com.bissy.distrib.bookstore.Book;
import com.bissy.distrib.bookstore.BookFactory;
import java.util.Collection;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BookViewer extends javax.swing.JFrame {

    /** Creates new form BookViewer */
    private BookStoreClient bookStoreClient;
    
    public BookViewer(BookStoreClient bsc) {
        initComponents();
        this.bookStoreClient = bsc;
    }

    public void setBooks(Collection<Book> books) {
        jTable1.setModel(new BookTableModel(books));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jAskFactory = new javax.swing.JMenuItem();
        jAskStore = new javax.swing.JMenuItem();
        jFindBook = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("Livres");

        jAskFactory.setText("Liste des livres à la fabrique");
        jAskFactory.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAskFactoryActionPerformed(evt);
            }
        });
        jMenu1.add(jAskFactory);

        jAskStore.setText("Liste des livres au magazin");
        jAskStore.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAskStoreActionPerformed(evt);
            }
        });
        jMenu1.add(jAskStore);

        jFindBook.setText("Chercher un livre");
        jFindBook.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFindBookActionPerformed(evt);
            }
        });
        jMenu1.add(jFindBook);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAskFactoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAskFactoryActionPerformed
        setBooks(BookFactory.createBooks());
    }//GEN-LAST:event_jAskFactoryActionPerformed

    private void jAskStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAskStoreActionPerformed
//        setBooks(Collections.EMPTY_LIST);
        try {
            setBooks(bookStoreClient.findAllBooks());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//GEN-LAST:event_jAskStoreActionPerformed

    private void jFindBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFindBookActionPerformed
        String title = JOptionPane.showInputDialog(null, "Titre du livre ?",
                "Titre du livre", JOptionPane.QUESTION_MESSAGE);
        try {
            setBooks(bookStoreClient.findBooks(title));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//GEN-LAST:event_jFindBookActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jAskFactory;
    private javax.swing.JMenuItem jAskStore;
//    private javax.swing.JMenuItem jBuy;
    private javax.swing.JMenuItem jFindBook;
//    private javax.swing.JMenuItem jGetPrice;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private Book getSelectedBook() {
        int row = jTable1.getSelectedRow();
        BookTableModel model = (BookTableModel) jTable1.getModel();
        return model.getBookArray()[row];
    }

    public static class BookTableModel extends DefaultTableModel {

        private Book[] bookArray;

        public BookTableModel(Collection<Book> books) {
            super(new String[]{"Titre", "Isbn", "Auteur"}, 0);
            int i = 0;
            bookArray = books.toArray(new Book[]{});
            for (Book book : books) {
                insertRow(i++, new String[]{
                            book.getTitle(),
                            book.getIsbn(),
                            String.format("%s %s", book.getAuthor().getFirstName(), book.getAuthor().getLastName())});
            }
        }

        public Book[] getBookArray() {
            return bookArray;
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return column > 0;
        }
    }
}
