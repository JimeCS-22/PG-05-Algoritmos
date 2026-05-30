package ucr.algoritmos.pg05algoritmos.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import ucr.algoritmos.pg05algoritmos.model.Tree.*;

import static ucr.algoritmos.pg05algoritmos.model.Tree.TreePainter.drawSimpleNode;
import static ucr.algoritmos.pg05algoritmos.model.Tree.TreePainter.drawTreeNode;


public class MainController {

    @FXML
    private TabPane mainTabs;

    ///-------AVL TREE------------
    @FXML
    private Button btnAddAvl;
    @FXML
    private Button btnPlayAvl;
    @FXML
    private Button btnRemoveAvl;
    @FXML
    private Button btnClearAvl;
    @FXML
    private Button btnSearchAvl;
    @FXML
    private Label lblAvlInfo;
    @FXML
    private Label lblRotacion;
    @FXML
    private Canvas canvasAVL;
    @FXML
    private TextField txtAvlValue;
    @FXML
    private ComboBox<String> cbRecorridos;
    @FXML
    private Label lblTours;
    @FXML
    private Label lblAvlInfo1;
    private AVL<Integer> avl;

    /////---------
    @FXML
    private Button btnEliminarInicio;
    @FXML
    private TextField txtName;
    @FXML
    private Button btnClearListDoble;
    @FXML
    private TextArea txAreaNodeStructureD;
    @FXML
    private TableColumn colStock;
    @FXML
    private Label txtInsertar;
    @FXML
    private Label txtInsertadoInDoubly;
    @FXML
    private Button btnAgregarDoble;
    @FXML
    private Button btnOrdenarStock;
    @FXML
    private TextField txtStock;
    @FXML
    private TableColumn colIdDoubly;
    @FXML
    private ListView listViewOperationsListDoubly;
    @FXML
    private TextField txtId;
    @FXML
    private TableColumn colRegDate;
    @FXML
    private TextField txtPrice;
    @FXML
    private Button btnOrdenarNombre;
    @FXML
    private Button btnEliminarDoble;
    @FXML
    private TableView tableCircularDoubly;
    @FXML
    private TableColumn colNombre;
    @FXML
    private ChoiceBox bxType;
    @FXML
    private Button btnSearchDoble;
    @FXML
    private Button btnEliminarFinal;
    @FXML
    private TableColumn colType;
    @FXML
    private TextArea txAreaNodeRepreDoubly;

    @FXML
    private Canvas canvasListDoubly;
    @FXML
    private DatePicker dpRegisterDate;
    @FXML
    private TableColumn colPrice;

    /////---------BTREE----------////

    @FXML
    private TextField txtValueBTree;
    @FXML
    private Label lblTours1;
    @FXML
    private Canvas canvasBTree;
    @FXML
    private Label lblBTreeinfo;
    @FXML
    private Button btnClearBTree;
    @FXML
    private ComboBox cbRecorridosBTree;
    @FXML
    private Button btnAddBTree;
    @FXML
    private Button btnPlayBTree;
    @FXML
    private Button btnRemoveBTree;
    @FXML
    private HBox RecorridosBTree;
    @FXML
    private Label lblBTreeDelete;
    private BTree<Integer> bTree;

//  -------------


    @FXML
    public void initialize() {
       setupBinaryTree();
        //setupBST();
        setupAVL();
    }

    /// Methods Controller for AVL TREE tab - Camila
    private void setupAVL() {
        avl = new AVL<>();

        //config botones de operaciones
        btnAddAvl.setOnAction(e -> {
            try {
                addAVL();
            } catch (TreeException ex) {
                throw new RuntimeException(ex);
            }
        });
        btnSearchAvl.setOnAction(e -> runSearchAVL());
        btnRemoveAvl.setOnAction(e -> removeAVL());
        btnClearAvl.setOnAction(e -> clearAVL());
        btnPlayAvl.setOnAction(e -> {
            try {
                playTours();
            } catch (TreeException ex) {
                throw new RuntimeException(ex);
            }
        });

        cbRecorridos.setItems(FXCollections.observableArrayList("PreOrder",
                "InOrder", "PostOrder"
        ));
        cbRecorridos.getSelectionModel().selectFirst();

    }

    private void addAVL() throws TreeException {
        int input = Integer.parseInt(txtAvlValue.getText().trim());

        if (input < 0 || txtAvlValue.getText() == null) {
            showAlert("Error", "Debe ingresar un número positivo");
            return;
        }

        avl.add(input);
        String result = avl.toString();

        // colocar el registro de operaciones
        try {
            registrarOperacion(avl.size(),avl.height(input),avl.isBalanced());
            lblRotacion.setText(avl.getRebalancingInfo());
        } catch (TreeException e) {
            throw new RuntimeException(e);
        }

        lblAvlInfo1.setText("Node "+input+" agregado del árbol");
        // agregar nodo al arbol
        drawAVL(avl);//dibujar la acción de add en el Canvas

    }

    private void runSearchAVL() {
        int input = Integer.parseInt(txtAvlValue.getText().trim());

        // Validación
        if (input < 0 || txtAvlValue.getText().isBlank()) {
            showAlert("Error", "Debe ingresar un número positivo");
            return;
        }

        try {
            // Buscar en la lista enlazada
            boolean posicion = avl.contains(input);

            if (posicion) {
                // Valor encontrado
                lblAvlInfo1.setText("Node "+input+" encontrado en el árbol");
                showAlert("Resultado de búsqueda",
                        "El valor \"" + input + "\" fue encontrado en el árbol");
            } else {
                // Valor NO encontrado
                lblAvlInfo1.setText("Node "+input+" no encontrado en el árbol");
                showAlert("Resultado de búsqueda","El valor \"" + input + "\" no se encuentra en el árbol");

            }
            // registrar operación
            registrarOperacion(avl.size(),avl.height(input),avl.isBalanced());
            drawAVL(avl);
        } catch (Exception e) {
            showAlert("Error", "Error al buscar el valor");
        }
    }
    private void removeAVL() {
        try {
            int input = Integer.parseInt(txtAvlValue.getText().trim());

            if (input < 0) {
                showAlert("Error", "Debe ingresar número positivo");
                return;
            }

            //  eliminar de la estructura
            avl.remove(input);

            // actualizar representación textual
            //listViewRecorridos. setText(avl.toString());

            // registrar operación
            registrarOperacion(avl.size(),avl.height(input),avl.isBalanced());
            lblAvlInfo1.setText("Node "+input+" eliminado del árbol");
            drawAVL(avl);

        } catch (NumberFormatException e) {
            showAlert("Error", "Valor inválido");
        } catch (Exception e) {
            showAlert("Error", "Error al eliminar nodo");
            e.printStackTrace();
        }
    }
    private void clearAVL() {
        avl.root = null;//vaciar árbol
        txtAvlValue.clear();
        lblTours.setText("--");
        lblAvlInfo.setText("--");
        lblRotacion.setText("--");
        lblAvlInfo1.setText("--");
        clearCanvasList();
    }

    private void clearCanvasList() {
        GraphicsContext gc = canvasAVL.getGraphicsContext2D();
        gc.clearRect(0, 0, canvasAVL.getWidth(), canvasAVL.getHeight());
    }

    private void playTours() throws TreeException {
       String tour = cbRecorridos.getSelectionModel().getSelectedItem();
        switch (tour) {
            case "PreOrder":
                lblTours.setText("PreOrder: ["+avl.preOrder() +"]");
                break;
            case "InOrder":
                lblTours.setText("InOrder: ["+avl.inOrder()+"]");
                break;
            case "PostOrder":
                lblTours.setText("PostOrder: ["+avl.postOrder()+"]");
                break;
        }
    }

    private void drawAVL(AVL<Integer> tree) throws TreeException {
        // graphicContext:forma de "dibujar" es como un objeto
        GraphicsContext treeGraphic = canvasAVL.getGraphicsContext2D();
        // limpiar cada vez antes de entrar al if
        treeGraphic.clearRect(0, 0, canvasAVL.getWidth(), canvasAVL.getHeight());

        // avl tree
        if (avl.root != null) {// si hay raiz entonces permite llamar metodo drawBTreeNodes
            // getWidth()/2 para que se centrara el arbol
            if (tree.root.equals(avl.root)) {
                drawTreeNode(treeGraphic, avl.root, canvasAVL.getWidth() / 2, 40, canvasAVL.getWidth() / 4,tree, true);
            }else{
                drawTreeNode(treeGraphic, avl.root, canvasAVL.getWidth() / 2, 40, canvasAVL.getWidth() / 4,tree, false);
            }

        }

    }

    private void registrarOperacion(int nodos, int altura, boolean isBalanced) {
        String texto = "Nodos: " +nodos + "| Altura: " + altura + "| Balanceado:  " + isBalanced;
        lblAvlInfo.setText(texto);
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /// Methods Controller for BTREE tab - Jimena
    private void setupBinaryTree() {

        bTree = new BTree<>();

        btnAddBTree.setOnAction(e -> addBTree());

        btnRemoveBTree.setOnAction(e -> removeBTree());

        btnClearBTree.setOnAction(e -> clearBTree());

        btnPlayBTree.setOnAction(e -> {
            try {
                playToursBTree();
            } catch (TreeException ex) {
                throw new RuntimeException(ex);
            }
        });

        cbRecorridosBTree.setItems(
                FXCollections.observableArrayList(
                        "PreOrder",
                        "InOrder",
                        "PostOrder"
                )
        );

        cbRecorridosBTree.getSelectionModel().selectFirst();
    }

    private void addBTree() {

        try {

            int value = Integer.parseInt(
                    txtValueBTree.getText().trim()
            );

            bTree.addBFS(value);

            lblBTreeDelete.setText(
                    "Insertado: " + value
            );

            updateBTreeInfo();

            drawBTree();

        } catch (Exception e) {

            showAlert(
                    "Error",
                    "Ingrese un número válido"
            );
        }
    }

    private void removeBTree() {

        try {

            int value = Integer.parseInt(
                    txtValueBTree.getText().trim()
            );

            bTree.remove(value);

            lblBTreeDelete.setText(
                    "Eliminado: " + value
            );

            updateBTreeInfo();

            drawBTree();

        } catch (Exception e) {

            showAlert(
                    "Error",
                    "No se pudo eliminar"
            );
        }
    }

    private void clearBTree() {

        bTree.clear();

        txtValueBTree.clear();

        lblTours1.setText("");

        lblBTreeinfo.setText("");

        lblBTreeDelete.setText("");

        GraphicsContext gc =
                canvasBTree.getGraphicsContext2D();

        gc.clearRect(
                0,
                0,
                canvasBTree.getWidth(),
                canvasBTree.getHeight()
        );
    }

    private void updateBTreeInfo() {

        try {

            lblBTreeinfo.setText(
                    "Nodos: "
                            + bTree.size()
                            + " | Altura: "
                            + bTree.height()
            );

        } catch(Exception e){

            lblBTreeinfo.setText(
                    "Nodos: 0 | Altura: 0"
            );
        }
    }

    private void playToursBTree() throws TreeException {

        String recorrido =
                (String) cbRecorridosBTree
                        .getSelectionModel()
                        .getSelectedItem();

        switch (recorrido) {

            case "PreOrder":

                lblTours1.setText(
                        "PreOrder: ["
                                + bTree.preOrder()
                                + "]"
                );
                break;

            case "InOrder":

                lblTours1.setText(
                        "InOrder: ["
                                + bTree.inOrder()
                                + "]"
                );
                break;

            case "PostOrder":

                lblTours1.setText(
                        "PostOrder: ["
                                + bTree.postOrder()
                                + "]"
                );
                break;
        }
    }

    private void drawBTree() {

        GraphicsContext gc =
                canvasBTree.getGraphicsContext2D();

        gc.clearRect(
                0,
                0,
                canvasBTree.getWidth(),
                canvasBTree.getHeight()
        );

        if(bTree.root != null){

            TreePainter.drawSimpleNode(
                    gc,
                    bTree.root,
                    canvasBTree.getWidth()/2,
                    60,
                    canvasBTree.getWidth()/4,
                    true
            );
        }
    }



}