package com.mycompany.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe rappresenta un item dell'inventario.
 */
public final class InventoryModel implements Serializable {
    /**
     * ID dell'item.
     */
    private int id;

    /**
     * Nome dell'item.
     */
    private String itemName;

    /**
     * Descrizione dell'item.
     */
    private String itemDescription;

    /**
     * Lista di item.
     */
    private static List<InventoryModel> list = new ArrayList<>();

    /**
     * Costruttore.
     */
    public InventoryModel() {
    }

    /**
     * Restituisce l'id dell'item.
     * @return id dell'item
     */
    public int getId() {
        return id;
    }

    /**
     * Restituisce il nome dell'item.
     * @return nome dell'item
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Restituisce la descrizione dell'item.
     * @return descrizione dell'item
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Imposta l'id dell'item.
     * @param idParam id dell'item
     */
    public void setId(final int idParam) {
        this.id = idParam;
    }

    /**
     * Imposta il nome dell'item.
     * @param itemNameParam nome dell'item
     */
    public void setItemName(final String itemNameParam) {
        this.itemName = itemNameParam;
    }

    /**
     * Imposta la descrizione dell'item.
     * @param itemDescriptionParam descrizione dell'item
     */
    public void setItemDescription(final String itemDescriptionParam) {
        this.itemDescription = itemDescriptionParam;
    }

    /**
     * Setta la lista di item.
     * @param listParam lista di item
     */
    public static void addToList(final InventoryModel model) {
        list.add(model);
    }

    /**
     * Restituisce la lista di item.
     */
    public static List<InventoryModel> getList() {
        return list;
    }
}
