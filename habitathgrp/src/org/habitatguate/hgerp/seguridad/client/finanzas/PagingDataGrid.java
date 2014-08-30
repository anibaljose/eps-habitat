package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionModel;
 
/**
 * Abstract PaggingDataGrid class to set initial GWT DataGrid and Simple Pager with ListDataProvider
 * 
 * @author Ravi Soni
 *
 * @param <T>
 */
public abstract class PagingDataGrid<T> extends Composite {
 
    private DataGrid<T> dataGrid;
    private SimplePager pager;
    private String height;
    private ListDataProvider<T> dataProvider;
    private List<T> dataList;
    private DockPanel dock = new DockPanel();
	private Button botonEliminar;
	private Button botonRefresh;
    final MultiSelectionModel<T> selectionModel =
            new MultiSelectionModel<T>((ProvidesKey<T>)AuxParametro.KEY_PROVIDER);
    private final SqlServiceAsync loginService = GWT.create(SqlService.class);
	Iterator<T> iter = null;
	T objectoEliminado = null;
    public PagingDataGrid() {
        initWidget(dock);
        dataGrid = new DataGrid<T>();
        dataGrid.setWidth("100%");

        SimplePager.Resources pagerResources = GWT
                .create(SimplePager.Resources.class);
        pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0,
                true);
        pager.setDisplay(dataGrid);
        
        dataProvider = new ListDataProvider<T>();
        dataProvider.setList(new ArrayList<T>());
        dataGrid.setEmptyTableWidget(new HTML("No existen datos a mostrar"));
        ListHandler<T> sortHandler = new ListHandler<T>(dataProvider.getList());
        dataGrid.setSelectionModel(selectionModel, DefaultSelectionEventManager
                .<T> createCheckboxManager());
        initTableColumns(dataGrid, sortHandler);
 
        dataGrid.addColumnSortHandler(sortHandler);
 
        dataProvider.addDataDisplay(dataGrid);
        
        botonEliminar = new Button("Eliminar Parametro");
        botonRefresh = new Button("Refresh Datos");
        pager.setVisible(true);
        dataGrid.setVisible(true);
        botonEliminar.setVisible(true);
        dock.add(dataGrid, DockPanel.CENTER);
        dock.add(pager, DockPanel.SOUTH);
        dock.setWidth("100%");
        dock.setCellWidth(dataGrid, "100%");
        dock.setCellWidth(pager, "100%");
        dock.add(botonRefresh,DockPanel.EAST);
        dock.add(botonEliminar,DockPanel.EAST);
        botonEliminar.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
              // Commit the changes.
            	Set<T> lista = selectionModel.getSelectedSet();
            	iter = (Iterator<T>) lista.iterator();
        			while (iter.hasNext()){
        			objectoEliminado = iter.next();	
        			loginService.Eliminar_Parametro(((AuxParametro)objectoEliminado).getIdParametro(), new AsyncCallback<Long>() {
        				
        				@Override
        				public void onSuccess(Long result) {
                			System.out.println("Eliminado: " + result);
                			dataProvider.getList().remove(objectoEliminado);
        				}
        				
        				@Override
        				public void onFailure(Throwable caught) {
        					System.out.println(caught);
        					
        				}
        			});
        			}
        			
	
            }
          });
        
    }
 
    public void setEmptyTableWidget() {
        dataGrid.setEmptyTableWidget(new HTML(
                "The current request has taken longer than the allowed time limit. Please try your report query again."));
    }
 
    /**
     * 
     * Abstract Method to implements for adding Column into Grid
     * 
     * @param dataGrid
     * @param sortHandler
     */
    public abstract void initTableColumns(DataGrid<T> dataGrid,   ListHandler<T> sortHandler);
 
    public String getHeight() {
        return height;
    }
 
    public void setHeight(String height) {
        this.height = height;
        dataGrid.setHeight(height);
    }
 
    public List<T> getDataList() {
        return dataList;
    }
 
    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
        List<T> list = dataProvider.getList();
        list.addAll(this.dataList);
        dataProvider.refresh();
    }
 
    public ListDataProvider<T> getDataProvider() {
        return dataProvider;
    }
 
    public void setDataProvider(ListDataProvider<T> dataProvider) {
        this.dataProvider = dataProvider;
    }
 
}
