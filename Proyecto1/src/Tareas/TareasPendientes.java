
package Tareas;
import static Tareas.CrearTarea.cargarUsuariosEnComboBox;
import Tareas.Inicio;
import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeCellEditor;
import raven.cell.TableActionCellEditor;
import raven.cell.TableActionCellRender;
import raven.cell.TableActionEvent;

/**
 *
 * @author INFORMATIC
 */
public class TareasPendientes extends javax.swing.JFrame {
static String correo;
    DefaultTableModel table = new DefaultTableModel();
    JComboBox cmb = new JComboBox();
    public TareasPendientes() {
        //this.correo=correo;
        initComponents();
        llenar();
        cargarUsuariosEnComboBox("DOC/BD_LISTAUSER.txt",cmbUsuario);
        TableActionEvent event=new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("edit row"+row);
                Editor acc = new Editor(row);
                acc.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if(tblTareas.isEditing()){
                    tblTareas.getCellEditor().stopCellEditing();
                    eliminarLinea("DOC/BD_TAREAS.txt", row);
                }
                DefaultTableModel model = (DefaultTableModel) tblTareas.getModel();
                model.removeRow(row);
            }
            
        };
        tblTareas.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        tblTareas.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
    }
    public void filtrarTareasEInsertar(String nombreUsuario, String delimitador, int part) {
        DefaultTableModel modeltable = (DefaultTableModel) tblTareas.getModel();
        modeltable.setRowCount(0);
        try (BufferedReader br = new BufferedReader(new FileReader("DOC/BD_TAREAS.txt"))) {
            String linea;

            // Leer el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en partes
                String[] partes = linea.split(delimitador);

                // Si el primer campo (nombre del usuario) coincide, insertar en la tabla
                if (partes[part].equalsIgnoreCase(nombreUsuario)) {
                    modeltable.addRow(new Object[]{partes[0], partes[1], partes[2], partes[3], partes[4]}); // Insertar directamente los datos en la tabla
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public void filtrarTareas(String combinacion[], String delimitador, int part, int part2) {
        DefaultTableModel modeltable = (DefaultTableModel) tblTareas.getModel();
        modeltable.setRowCount(0);
        try (BufferedReader br = new BufferedReader(new FileReader("DOC/BD_TAREAS.txt"))) {
            String linea;

            // Leer el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en partes
                String[] partes = linea.split(delimitador);

                // Si el primer campo (nombre del usuario) coincide, insertar en la tabla
                if (partes[part].equalsIgnoreCase(combinacion[0])&& partes[part2].equalsIgnoreCase(combinacion[1])) {
                    modeltable.addRow(new Object[]{partes[0], partes[1], partes[2], partes[3], partes[4]}); // Insertar directamente los datos en la tabla
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public void filtrarTareastotal(String combinacion[], String delimitador, int part, int part2,int part3) {
        DefaultTableModel modeltable = (DefaultTableModel) tblTareas.getModel();
        modeltable.setRowCount(0);
        try (BufferedReader br = new BufferedReader(new FileReader("DOC/BD_TAREAS.txt"))) {
            String linea;

            // Leer el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en partes
                String[] partes = linea.split(delimitador);

                // Si el primer campo (nombre del usuario) coincide, insertar en la tabla
                if (partes[part].equals(combinacion[0])&& partes[part2].equals(combinacion[1]) && partes[part3].equals(combinacion[2])) {
                    modeltable.addRow(new Object[]{partes[0], partes[1], partes[2], partes[3], partes[4]}); // Insertar directamente los datos en la tabla
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTareas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnIni4 = new javax.swing.JButton();
        btnUsuario4 = new javax.swing.JButton();
        btnHistorial4 = new javax.swing.JButton();
        btnCrearT4 = new javax.swing.JButton();
        btnListaT4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cmbUsuario = new javax.swing.JComboBox<>();
        cmbPrioridad = new javax.swing.JComboBox<>();
        cmbEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Tarea", "Descripcion", "Prioridad", "Estado", "action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTareas.setRowHeight(40);
        jScrollPane1.setViewportView(tblTareas);
        if (tblTareas.getColumnModel().getColumnCount() > 0) {
            tblTareas.getColumnModel().getColumn(2).setMinWidth(300);
            tblTareas.getColumnModel().getColumn(2).setMaxWidth(300);
            tblTareas.getColumnModel().getColumn(5).setMaxWidth(60);
        }

        jLabel1.setText("Tareas Pendientes");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnIni4.setText("Inicio");
        btnIni4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIni4ActionPerformed(evt);
            }
        });

        btnUsuario4.setText("Usuario");
        btnUsuario4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuario4ActionPerformed(evt);
            }
        });

        btnHistorial4.setText("Historial");
        btnHistorial4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorial4ActionPerformed(evt);
            }
        });

        btnCrearT4.setText("Crear Tarea");
        btnCrearT4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearT4ActionPerformed(evt);
            }
        });

        btnListaT4.setText("Lista de tareas");

        jButton2.setText("Crear Cuenta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListaT4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(btnCrearT4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(btnHistorial4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(btnUsuario4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(btnIni4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnIni4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCrearT4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnListaT4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHistorial4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        cmbUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUsuarioActionPerformed(evt);
            }
        });

        cmbPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Alta", "Media", "Baja" }));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Por Hacer", "En proceso", "Terminado" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(cmbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(cmbPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(81, 81, 81)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//manolito-cantar-musicas-Media-Por Hacer-12/12/24-13:00-15/12/24-14:00
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(cmbUsuario.getSelectedItem().toString().equals("Todos") && cmbPrioridad.getSelectedItem().toString().equals("Todos") && cmbEstado.getSelectedItem().toString().equals("Todos") ){
            DefaultTableModel modeltable = (DefaultTableModel) tblTareas.getModel();
            modeltable.setRowCount(0);
            llenar();
        }else if(!cmbUsuario.getSelectedItem().toString().equals("Todos") && cmbPrioridad.getSelectedItem().toString().equals("Todos") && cmbEstado.getSelectedItem().toString().equals("Todos")){
            filtrarTareasEInsertar(cmbUsuario.getSelectedItem().toString(), "-",0);
        }else if(cmbUsuario.getSelectedItem().toString().equals("Todos") && !cmbPrioridad.getSelectedItem().toString().equals("Todos") && cmbEstado.getSelectedItem().toString().equals("Todos")){
            filtrarTareasEInsertar(cmbPrioridad.getSelectedItem().toString(), "-",3);
        }else if(cmbUsuario.getSelectedItem().toString().equals("Todos") && cmbPrioridad.getSelectedItem().toString().equals("Todos") && !cmbEstado.getSelectedItem().toString().equals("Todos")){
            filtrarTareasEInsertar(cmbEstado.getSelectedItem().toString(), "-",4);
        }else if(!cmbUsuario.getSelectedItem().toString().equals("Todos") && !cmbPrioridad.getSelectedItem().toString().equals("Todos") && cmbEstado.getSelectedItem().toString().equals("Todos")){
            String combinacion[] = new String[2];
            combinacion[0]=cmbUsuario.getSelectedItem().toString();
            combinacion[1]=cmbPrioridad.getSelectedItem().toString();
            filtrarTareas(combinacion,"-",0,3);
        }else if(cmbUsuario.getSelectedItem().toString().equals("Todos") && !cmbPrioridad.getSelectedItem().toString().equals("Todos") && !cmbEstado.getSelectedItem().toString().equals("Todos")){
            String combinacion[] = new String[2];
            combinacion[0]=cmbPrioridad.getSelectedItem().toString();
            combinacion[1]=cmbEstado.getSelectedItem().toString();
            filtrarTareas(combinacion,"-",3,4);
        }else if(!cmbUsuario.getSelectedItem().toString().equals("Todos") && cmbPrioridad.getSelectedItem().toString().equals("Todos") && !cmbEstado.getSelectedItem().toString().equals("Todos")){
            String combinacion[] = new String[2];
            combinacion[0]=cmbUsuario.getSelectedItem().toString();
            combinacion[1]=cmbEstado.getSelectedItem().toString();
            filtrarTareas(combinacion,"-",0,4);
        }else if(!cmbUsuario.getSelectedItem().toString().equals("Todos") && !cmbPrioridad.getSelectedItem().toString().equals("Todos") && !cmbEstado.getSelectedItem().toString().equals("Todos")){
            String combinacion[] = new String[3];
            combinacion[0]=cmbUsuario.getSelectedItem().toString();
            combinacion[1]=cmbPrioridad.getSelectedItem().toString();
            combinacion[2]=cmbEstado.getSelectedItem().toString();
            filtrarTareastotal(combinacion,"-",0,3,4);
        }
        
        //filtrarTareasEInsertar(cmbUsuario.getSelectedItem().toString(), "-",0);
    }//GEN-LAST:event_jButton1ActionPerformed
    public static void cargarUsuariosEnComboBox(String rutaArchivo, JComboBox<String> comboBox) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            comboBox.addItem("Todos");
            while ((linea = br.readLine()) != null) {
                // Divide la línea en partes usando el separador "-"
                String[] partes = linea.split("-");
                if (partes.length > 0) {
                    // El primer elemento es el nombre del usuario
                    String nombreUsuario = partes[0];
                    comboBox.addItem(nombreUsuario);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    private void btnIni4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIni4ActionPerformed
        ListaUser acc = new ListaUser();
        acc.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnIni4ActionPerformed

    private void btnUsuario4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuario4ActionPerformed
        ListaUserAcciones acc = new ListaUserAcciones();
        acc.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnUsuario4ActionPerformed

    private void btnCrearT4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearT4ActionPerformed
        CrearTarea acc = new CrearTarea();
        acc.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCrearT4ActionPerformed

    private void cmbUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUsuarioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CrearCuenta acc = new CrearCuenta();
        acc.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnHistorial4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorial4ActionPerformed
        Historial his = new Historial();
        his.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHistorial4ActionPerformed
    
    void eventos(){
    String prioridad[] = {"Baja", "Media", "Alta"};
    String estado[] = {"Terminado", "Por Hacer", "En Proceso"};
    JComboBox<String> cmb = new JComboBox<>(); // Asegúrate de inicializar el JComboBox antes de usarlo.
    JComboBox<String> cmbo = new JComboBox<>();
    // Llenar el JComboBox con los valores de prioridad.
    for (String prioridad1 : prioridad ) {
        cmb.addItem(prioridad1);         
    }
    for (String estado1 : estado ) {
        cmbo.addItem(estado1);         
    }
    // Asignar el JComboBox como editor de celdas en la columna 2 del JTable.
    tblTareas.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(cmb));
    tblTareas.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(cmbo));
}
    public static void eliminarLinea(String rutaArchivo, int numeroLinea) {
    File archivo = new File(rutaArchivo);
    File archivoTemporal = new File(archivo.getAbsolutePath() + ".tmp");

    try (BufferedReader reader = new BufferedReader(new FileReader(archivo));
         BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal))) {

        String linea;
        int lineaActual = 0;

        while ((linea = reader.readLine()) != null) {
            if (lineaActual != numeroLinea) {
                writer.write(linea);
                writer.newLine();
            }
            lineaActual++;
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    // Reemplazar el archivo original con el archivo temporal
    if (!archivo.delete()) {
        System.err.println("No se pudo eliminar el archivo original.");
    }
    if (!archivoTemporal.renameTo(archivo)) {
        System.err.println("No se pudo renombrar el archivo temporal.");
    }
}

    /*public void llenar(String ru) {
        String ruta = "DOC/DOCTAREAS//BD_"+ru+".txt"; 
        DefaultTableModel modeltable = (DefaultTableModel)tblTareas.getModel();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
        String linea1 = br.readLine();
        String linea2 = "";
        String linea3 = "";
        String linea4 = "";
        String linea5 = "";
        
        
        while (linea1 != null) {
            for(int j=0 ; j==4 ; j++){
                for(int i=0;linea1.charAt(i)!='-';i++){
                    if(linea2==""){
                        linea2=""+linea1.charAt(i);
                    }else if(linea3==""){
                        linea3=""+linea1.charAt(i);
                    }else if(linea4==""){
                        linea4=""+linea1.charAt(i);
                    }else{
                        linea5=""+linea1.charAt(i);
                    }
                    linea1=linea1.substring(i+1);
                }
            }
            modeltable.addRow(new Object[]{linea2, linea3, linea4, linea5, null, null, null});
            linea1 = br.readLine(); // Mover fuera del if para que se ejecute siempre
        }
    } catch (IOException e) {
        System.err.println("Error al leer el archivo: " + e.getMessage());
    }
    }*/
    /*public void llenar() {
    String ruta = "DOC/BD_TAREAS.txt"; 
    DefaultTableModel modeltable = (DefaultTableModel) tblTareas.getModel();
    int i=0;
    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
        String linea1 = br.readLine();
        
        while (linea1 != null) {
            // Separar los elementos por el delimitador '-'
            String[] partes = linea1.split("-");
            
            if (partes.length == 5) {
                // Asegurarse de que hay 4 partes para evitar ArrayIndexOutOfBoundsException
                modeltable.addRow(new Object[]{partes[0], partes[1], partes[2], partes[3], partes[4], null});
                if(partes[4].equals("En Proceso")){
                        changeRowColor(tblTareas,i, Color.red);

                }else if(partes[4].equals("Por Hacer")){
                        changeRowColor(tblTareas,i, Color.yellow);
                        
                }else{
                        changeRowColor(tblTareas,i, Color.green);
                        
                }
                
                
                
            } else {
                // Si no hay 4 partes, manejar el error o ignorar la línea
                System.err.println("Error en el formato de la línea: " + linea1);
            }
            
            linea1 = br.readLine(); // Leer la siguiente línea
        }
        
    } catch (IOException e) {
        System.err.println("Error al leer el archivo: " + e.getMessage());
        e.printStackTrace();
    }
    }*/
    public void llenar() {
    String ruta = "DOC/BD_TAREAS.txt"; 
    DefaultTableModel modeltable = (DefaultTableModel) tblTareas.getModel();

    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
        String linea1 = br.readLine();
        
        while (linea1 != null) {
            // Separar los elementos por el delimitador '-'
            String[] partes = linea1.split("-");
            
            if (partes.length == 9) {
                // Agregar la fila al modelo de la tabla
                modeltable.addRow(new Object[]{partes[0], partes[1], partes[2], partes[3], partes[4]});
            } else {
                System.err.println("Error en el formato de la línea: " + linea1);
            }
            
            linea1 = br.readLine(); // Leer la siguiente línea
        }
        
    } catch (IOException e) {
        System.err.println("Error al leer el archivo: " + e.getMessage());
        e.printStackTrace();
    }

    // Configurar un renderizador único para cambiar colores según el estado
    tblTareas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Obtener el estado de la fila actual
            String estado = (String) table.getValueAt(row, 4); // Columna "Estado"
            switch (estado) {
                case "En proceso":
                    c.setBackground(Color.YELLOW);
                    break;
                case "Por Hacer":
                    c.setBackground(Color.RED);
                    break;
                case "Terminado":
                    c.setBackground(Color.GREEN);
                    break;
                default:
                    c.setBackground(Color.WHITE); // Color por defecto
                    break;
            }

            // Resaltar la selección
            if (isSelected) {
                c.setBackground(c.getBackground().darker());
            }

            return c;
        }
    });
}   
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(TareasPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TareasPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TareasPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TareasPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TareasPendientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearT4;
    private javax.swing.JButton btnHistorial4;
    private javax.swing.JButton btnIni4;
    private javax.swing.JButton btnListaT4;
    private javax.swing.JButton btnUsuario4;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbPrioridad;
    private javax.swing.JComboBox<String> cmbUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTareas;
    // End of variables declaration//GEN-END:variables
}
