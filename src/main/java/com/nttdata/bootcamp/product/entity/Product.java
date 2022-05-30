package com.nttdata.bootcamp.product.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Data;

@Document("product")
@Data
@Builder
public class Product implements Serializable {
private static final long serialVersionUID = -8679693676390266508L;
@Id
private String id;
@Field
private String description;
@Field
private String category;
}
