package com.example.lab_3;


public class Laptop {

    private String manufacturer;
    private String model;
    private String price;
    private String releaseDate;
    private String processor;

    public Laptop(String manufacturer, String model, String price, String releaseDate, String processor) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.releaseDate = releaseDate;
        this.processor = processor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laptop laptop = (Laptop) o;

        if (!manufacturer.equals(laptop.manufacturer)) return false;
        if (!model.equals(laptop.model)) return false;
        if (!price.equals(laptop.price)) return false;
        if (!releaseDate.equals(laptop.releaseDate)) return false;
        return processor.equals(laptop.processor);
    }

    @Override
    public int hashCode() {
        int result = manufacturer.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + releaseDate.hashCode();
        result = 31 * result + processor.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return """
{
"Производитель": "%s",
"Модель": "%s",
"Цена": "%s",
"Дата производства": "%s",
"Процессор": "%s"
}
""".formatted(manufacturer, model, price, releaseDate, processor);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }
}

