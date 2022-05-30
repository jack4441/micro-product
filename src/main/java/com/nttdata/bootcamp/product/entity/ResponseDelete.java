package com.nttdata.bootcamp.product.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDelete  implements Serializable {
private static final long serialVersionUID = 4693902124158463233L;
private String response;
}
