package mx.reel.pojos;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Estate implements Serializable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image_id")
    @Expose
    private String imageId;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("owner_id")
    @Expose
    private int ownerId;
    @SerializedName("estate_type")
    @Expose
    private EstateType estateType;
    @SerializedName("business_type")
    @Expose
    private int businessType;
    @SerializedName("commision_or_advertising")
    @Expose
    private int commisionOrAdvertising;
    @SerializedName("sell_or_rent")
    @Expose
    private String sellOrRent;
    @SerializedName("ejidal_or_private")
    @Expose
    private String ejidalOrPrivate;
    @SerializedName("surface_area")
    @Expose
    private int surfaceArea;
    @SerializedName("seller_price")
    @Expose
    private int sellerPrice;
    @SerializedName("seller_minimum_price")
    @Expose
    private Object sellerMinimumPrice;
    @SerializedName("meter_price")
    @Expose
    private int meterPrice;
    @SerializedName("front_meters")
    @Expose
    private Object frontMeters;
    @SerializedName("long_meters")
    @Expose
    private Object longMeters;
    @SerializedName("has_underground_water")
    @Expose
    private String hasUndergroundWater;
    @SerializedName("agent_comments")
    @Expose
    private Object agentComments;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("city_id")
    @Expose
    private int cityId;
    @SerializedName("state_id")
    @Expose
    private Object stateId;
    @SerializedName("has_drinkable_water")
    @Expose
    private String hasDrinkableWater;
    @SerializedName("sewer_system")
    @Expose
    private String sewerSystem;
    @SerializedName("public_light")
    @Expose
    private String publicLight;
    @SerializedName("is_heritage")
    @Expose
    private String isHeritage;
    @SerializedName("is_needy")
    @Expose
    private String isNeedy;
    @SerializedName("bathrooms")
    @Expose
    private Object bathrooms;
    @SerializedName("parking_lots")
    @Expose
    private Object parkingLots;
    @SerializedName("floors")
    @Expose
    private Object floors;
    @SerializedName("construction_area")
    @Expose
    private Object constructionArea;
    @SerializedName("bedrooms")
    @Expose
    private Object bedrooms;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;
    @SerializedName("full_address")
    @Expose
    private String fullAddress;
    @SerializedName("visit")
    @Expose
    private int visit;
    @SerializedName("images")
    @Expose
    private List<EstateImage> images = null;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("state")
    @Expose
    private Object state;
    private final static long serialVersionUID = 1892748225239403165L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Estate() {
    }

    /**
     *
     * @param sewerSystem
     * @param estateType
     * @param surfaceArea
     * @param sellerPrice
     * @param isHeritage
     * @param agentComments
     * @param city
     * @param commisionOrAdvertising
     * @param meterPrice
     * @param latitude
     * @param description
     * @param cityId
     * @param ownerId
     * @param createdAt
     * @param longMeters
     * @param floors
     * @param id
     * @param state
     * @param constructionArea
     * @param longitude
     * @param updatedAt
     * @param images
     * @param imageId
     * @param address
     * @param publicLight
     * @param stateId
     * @param sellerMinimumPrice
     * @param bathrooms
     * @param frontMeters
     * @param bedrooms
     * @param parkingLots
     * @param sellOrRent
     * @param name
     * @param fullAddress
     * @param hasUndergroundWater
     * @param visit
     * @param businessType
     * @param hasDrinkableWater
     * @param ejidalOrPrivate
     * @param isNeedy
     * @param status
     */
    public Estate(int id, String name, String imageId, String description, int ownerId, EstateType estateType, int businessType, int commisionOrAdvertising, String sellOrRent, String ejidalOrPrivate, int surfaceArea, int sellerPrice, Object sellerMinimumPrice, int meterPrice, Object frontMeters, Object longMeters, String hasUndergroundWater, Object agentComments, String latitude, String longitude, String address, int cityId, Object stateId, String hasDrinkableWater, String sewerSystem, String publicLight, String isHeritage, String isNeedy, Object bathrooms, Object parkingLots, Object floors, Object constructionArea, Object bedrooms, String status, String createdAt, Object updatedAt, String fullAddress, int visit, List<EstateImage> images, City city, Object state) {
        super();
        this.id = id;
        this.name = name;
        this.imageId = imageId;
        this.description = description;
        this.ownerId = ownerId;
        this.estateType = estateType;
        this.businessType = businessType;
        this.commisionOrAdvertising = commisionOrAdvertising;
        this.sellOrRent = sellOrRent;
        this.ejidalOrPrivate = ejidalOrPrivate;
        this.surfaceArea = surfaceArea;
        this.sellerPrice = sellerPrice;
        this.sellerMinimumPrice = sellerMinimumPrice;
        this.meterPrice = meterPrice;
        this.frontMeters = frontMeters;
        this.longMeters = longMeters;
        this.hasUndergroundWater = hasUndergroundWater;
        this.agentComments = agentComments;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.cityId = cityId;
        this.stateId = stateId;
        this.hasDrinkableWater = hasDrinkableWater;
        this.sewerSystem = sewerSystem;
        this.publicLight = publicLight;
        this.isHeritage = isHeritage;
        this.isNeedy = isNeedy;
        this.bathrooms = bathrooms;
        this.parkingLots = parkingLots;
        this.floors = floors;
        this.constructionArea = constructionArea;
        this.bedrooms = bedrooms;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.fullAddress = fullAddress;
        this.visit = visit;
        this.images = images;
        this.city = city;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public EstateType getEstateType() {
        return estateType;
    }

    public void setEstateType(EstateType estateType) {
        this.estateType = estateType;
    }

    public int getBusinessType() {
        return businessType;
    }

    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    public int getCommisionOrAdvertising() {
        return commisionOrAdvertising;
    }

    public void setCommisionOrAdvertising(int commisionOrAdvertising) {
        this.commisionOrAdvertising = commisionOrAdvertising;
    }

    public String getSellOrRent() {
        return sellOrRent;
    }

    public void setSellOrRent(String sellOrRent) {
        this.sellOrRent = sellOrRent;
    }

    public String getEjidalOrPrivate() {
        return ejidalOrPrivate;
    }

    public void setEjidalOrPrivate(String ejidalOrPrivate) {
        this.ejidalOrPrivate = ejidalOrPrivate;
    }

    public int getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(int surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getSellerPrice() {
        return sellerPrice;
    }

    public void setSellerPrice(int sellerPrice) {
        this.sellerPrice = sellerPrice;
    }

    public Object getSellerMinimumPrice() {
        return sellerMinimumPrice;
    }

    public void setSellerMinimumPrice(Object sellerMinimumPrice) {
        this.sellerMinimumPrice = sellerMinimumPrice;
    }

    public int getMeterPrice() {
        return meterPrice;
    }

    public void setMeterPrice(int meterPrice) {
        this.meterPrice = meterPrice;
    }

    public Object getFrontMeters() {
        return frontMeters;
    }

    public void setFrontMeters(Object frontMeters) {
        this.frontMeters = frontMeters;
    }

    public Object getLongMeters() {
        return longMeters;
    }

    public void setLongMeters(Object longMeters) {
        this.longMeters = longMeters;
    }

    public String getHasUndergroundWater() {
        return hasUndergroundWater;
    }

    public void setHasUndergroundWater(String hasUndergroundWater) {
        this.hasUndergroundWater = hasUndergroundWater;
    }

    public Object getAgentComments() {
        return agentComments;
    }

    public void setAgentComments(Object agentComments) {
        this.agentComments = agentComments;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public Object getStateId() {
        return stateId;
    }

    public void setStateId(Object stateId) {
        this.stateId = stateId;
    }

    public String getHasDrinkableWater() {
        return hasDrinkableWater;
    }

    public void setHasDrinkableWater(String hasDrinkableWater) {
        this.hasDrinkableWater = hasDrinkableWater;
    }

    public String getSewerSystem() {
        return sewerSystem;
    }

    public void setSewerSystem(String sewerSystem) {
        this.sewerSystem = sewerSystem;
    }

    public String getPublicLight() {
        return publicLight;
    }

    public void setPublicLight(String publicLight) {
        this.publicLight = publicLight;
    }

    public String getIsHeritage() {
        return isHeritage;
    }

    public void setIsHeritage(String isHeritage) {
        this.isHeritage = isHeritage;
    }

    public String getIsNeedy() {
        return isNeedy;
    }

    public void setIsNeedy(String isNeedy) {
        this.isNeedy = isNeedy;
    }

    public Object getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Object bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Object getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(Object parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Object getFloors() {
        return floors;
    }

    public void setFloors(Object floors) {
        this.floors = floors;
    }

    public Object getConstructionArea() {
        return constructionArea;
    }

    public void setConstructionArea(Object constructionArea) {
        this.constructionArea = constructionArea;
    }

    public Object getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Object bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public int getVisit() {
        return visit;
    }

    public void setVisit(int visit) {
        this.visit = visit;
    }

    public List<EstateImage> getImages() {
        return images;
    }

    public void setImages(List<EstateImage> images) {
        this.images = images;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

}
