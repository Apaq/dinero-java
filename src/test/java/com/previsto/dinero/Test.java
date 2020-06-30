package com.previsto.dinero;

import com.previsto.dinero.model.*;
import org.apache.commons.io.FileUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

public class Test {

    public static void main(String[] args) throws IOException {

        String orgId = "107436";
        String apiKey = "59b54638e3d5463c917e10ee68d45bff";

        //String orgId = "148383";
        //String apiKey = "33591216d5184eb39bf8f564f223b9b9";


        DineroClient client = new DineroClient("Previsto",
                "ZfnZyhqoc3B7q9GDKEAToD0W5xTbnlEwMlf3YIPQE", orgId, apiKey,
                "https://authz.dinero.dk/dineroapi/oauth/token", "https://api.dinero.dk/v1");

        Invoice invoice = client.getInvoiceResource().get("58155e23-73b6-4178-97bf-0901ede01cde");//.get("e4f62426-3c2f-4fad-98c4-57fb4072d923");
        Invoice invoice2 = client.getInvoiceResource().get("bd8ea633-e582-461b-b20d-47066ddb197a");//.get("e4f62426-3c2f-4fad-98c4-57fb4072d923");
        System.out.println(invoice.getStatus());
        
    }
}
