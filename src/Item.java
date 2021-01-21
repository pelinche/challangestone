public class Item {

    private String description;
    private Integer quantity;
    private Integer unitaryValue;

    public Item() {
    }

    public Item(String description, Integer quantity, Integer unitaryValue) {
        this.description = description;
        this.quantity = quantity;
        this.unitaryValue = unitaryValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getUnitaryValue() {
        return unitaryValue;
    }

    public void setUnitaryValue(Integer unitaryValue) {
        this.unitaryValue = unitaryValue;
    }

    public Integer getTotalItem(){
        return (quantity * unitaryValue);
    }

    @Override
    public String toString() {
        return
                "Produto: "+getDescription()+
                        "  | Quantidade: "+getQuantity()+
                        "  | Unitario: R$ "+Utils.formatFloat( Utils.convertDouble(getUnitaryValue())/100)+
                        "  | Subtotal: R$ "+Utils.formatFloat( Utils.convertDouble(getTotalItem())/100);
    }
}