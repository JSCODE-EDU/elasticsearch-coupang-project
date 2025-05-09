package com.example.coupangapiserver.product.domain;

import jakarta.persistence.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = "products")
@Setting(settingPath = "/elasticsearch/product-settings.json")
public class ProductDocument {

  @Id
  private Long id;

  @MultiField(mainField = @Field(type = FieldType.Text, analyzer = "products_name_analyzer"),
      otherFields = {
          @InnerField(suffix = "auto_complete", type = FieldType.Search_As_You_Type, analyzer = "nori")
      }
  )
  private String name;

  @Field(type = FieldType.Text, analyzer = "products_description_analyzer")
  private String description;

  @Field(type = FieldType.Integer)
  private Integer price;

  @Field(type = FieldType.Double)
  private Double rating;

  @MultiField(mainField = @Field(type = FieldType.Text, analyzer = "products_category_analyzer"),
      otherFields = {
          @InnerField(suffix = "raw", type = FieldType.Keyword)
      }
  )
  private String category;

  public ProductDocument(Long id, String name, String description, Integer price, Double rating,
      String category) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.rating = rating;
    this.category = category;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Integer getPrice() {
    return price;
  }

  public Double getRating() {
    return rating;
  }

  public String getCategory() {
    return category;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}