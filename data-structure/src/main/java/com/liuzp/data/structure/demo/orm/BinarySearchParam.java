package com.liuzp.data.structure.demo.orm;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class BinarySearchParam implements Serializable {

    private double target;
    private double[] srotArr;
}
