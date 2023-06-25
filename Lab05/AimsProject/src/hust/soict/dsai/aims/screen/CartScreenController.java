package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.store;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.awt.Window;

public class CartScreenController {
	private Cart cart;
	private store store;
	
	@FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediacategory;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	
	@FXML
    private TextField tfFilter;
	
	public CartScreenController (store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}

	
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String>("title"));
		colMediacategory.setCellValueFactory(
				new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener( new ChangeListener<Media>() {
					
					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue,
							Media newValue) {
						if(newValue != null) {
							updateButtonBar(newValue);
						}
					}
				}
			);
//		tfFilter.textProperty().addListener(new ChangeListener<String>() {
//			@Override
//			public void changed(ObservableValue <? extends String> observable, String oldValue, String newValue) {
//				showFilteredMedia(newValue);
//			}
//		});
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
		}
	}

	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
	}
	
	private Window window;
	
	public void setWindow(Window window) {
		this.window = window;
	}
	
	@FXML
	void menuItemPressed(ActionEvent event) {
		MenuItem mi = (MenuItem)event.getSource();
		if (mi.getText().equals("Add Book")) {
			new AddBookToStoreScreen(store, cart);
			window.dispose();
		}
		else if (mi.getText().equals("Add CD")) {
			new AddCDToStoreScreen(store, cart);
			window.dispose();
		}
		else if (mi.getText().equals("Add DVD")) {
			new AddDVDToStoreScreen(store, cart);
			window.dispose();
		}
		else if (mi.getText().equals("View Store")) {
			new StoreScreen(store, cart);
			window.dispose();
		}
		else if (mi.getText().equals("View Cart")) {
			new CartScreen(store,cart);
			window.dispose();
		}
	}



	
}


