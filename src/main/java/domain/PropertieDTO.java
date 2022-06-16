package domain;
import java.util.Date;

public class PropertieDTO {
    private int idPropertie;
    private String title;
    private double price;
    private String picture;
    private String description;
    private int rooms;
    private int wc;
    private int parking;
    private Date created;
    private int sellerId;

    public PropertieDTO() {
    }

    public PropertieDTO(int idPropertie) {
        this.idPropertie = idPropertie;
    }

    public PropertieDTO(String title, double price, String picture, String description, int rooms, int wc, int parking, Date created, int selletId) {
        this.title = title;
        this.price = price;
        this.picture = picture;
        this.description = description;
        this.rooms = rooms;
        this.wc = wc;
        this.parking = parking;
        this.created = created;
        this.sellerId = selletId;
    }

    public PropertieDTO(int idPropertie, String title, double price, String picture, String description, int rooms, int wc, int parking, Date created, int selletId) {
        this.idPropertie = idPropertie;
        this.title = title;
        this.price = price;
        this.picture = picture;
        this.description = description;
        this.rooms = rooms;
        this.wc = wc;
        this.parking = parking;
        this.created = created;
        this.sellerId = selletId;
    }

    public int getIdPropertie() {
        return idPropertie;
    }

    public void setIdPropertie(int idPropertie) {
        this.idPropertie = idPropertie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getWc() {
        return wc;
    }

    public void setWc(int wc) {
        this.wc = wc;
    }

    public int getParking() {
        return parking;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "Properties{" + "idPropertie=" + idPropertie + ", title=" + title + ", price=" + price + ", picture=" + picture + ", description=" + description + ", rooms=" + rooms + ", wc=" + wc + ", parking=" + parking + ", created=" + created + ", selletId=" + sellerId + '}';
    }
    
    
    
}
