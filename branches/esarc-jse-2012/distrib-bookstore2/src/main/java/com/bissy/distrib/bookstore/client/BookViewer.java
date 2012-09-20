package com.bissy.distrib.bookstore.client;

import com.bissy.distrib.bookstore.Amount;
import com.bissy.distrib.bookstore.Book;
import com.bissy.distrib.bookstore.BookFactory;
import com.bissy.distrib.bookstore.BookStoreService;

import java.util.Collection;
import java.util.Collections;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class BookViewer extends javax.swing.JFrame {

	private BookStoreService bookStoreService;
	
    /** Creates new form BookViewer */
    public BookViewer(BookStoreService bookStoreService) {
        initComponents();
        setBooks(Collections.EMPTY_LIST);
        this.bookStoreService = bookStoreService;
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
        jGetPrice = new javax.swing.JMenuItem();
        jBuy = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
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

        jGetPrice.setText("Obtenir le prix");
        jGetPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGetPriceActionPerformed(evt);
            }
        });
        jMenu1.add(jGetPrice);

        jBuy.setText("Acheter");
        jBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuyActionPerformed(evt);
            }
        });
        jMenu1.add(jBuy);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAskFactoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAskFactoryActionPerformed
        setBooks(BookFactory.createBooks());
    }//GEN-LAST:event_jAskFactoryActionPerformed

    private void jAskStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAskStoreActionPerformed
        try {
			setBooks(bookStoreService.findAllBooks());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }//GEN-LAST:event_jAskStoreActionPerformed

    private void jFindBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFindBookActionPerformed
        String title = JOptionPane.showInputDialog(null, "Titre du livre ?",
                "Titre du livre", JOptionPane.QUESTION_MESSAGE);
        try {
			setBooks(bookStoreService.findBooks(title));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }//GEN-LAST:event_jFindBookActionPerformed

    private void jGetPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGetPriceActionPerformed
        try {
			Amount amount = bookStoreService.getPrice(getSelectedBook());
			JOptionPane.showMessageDialog(this, String.format("Le prix est de : %s", amount));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }//GEN-LAST:event_jGetPriceActionPerformed

    private void jBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuyActionPerformed
        String title = getSelectedBook().getTitle();
        String price = JOptionPane.showInputDialog(null, String.format("Donner votre prix d'achat pour %s ?",title),
                String.format("Donner le prix pour %s",title), JOptionPane.QUESTION_MESSAGE);
      Amount amount = Amount.parse(price); 
        try {
			bookStoreService.buy(getSelectedBook(), amount);
			setBooks(Collections.EMPTY_LIST);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			e.printStackTrace();
		}
    }//GEN-LAST:event_jBuyActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jAskFactory;
    private javax.swing.JMenuItem jAskStore;
    private javax.swing.JMenuItem jBuy;
    private javax.swing.JMenuItem jFindBook;
    private javax.swing.JMenuItem jGetPrice;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private Book getSelectedBook() {
        int row= jTable1.getSelectedRow();
        BookTableModel model = (BookTableModel)jTable1.getModel();
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
