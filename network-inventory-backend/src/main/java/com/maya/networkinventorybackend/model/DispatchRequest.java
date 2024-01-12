package com.maya.networkinventorybackend.model;

//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Entity
//public class DispatchRequest {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // Adjust the strategy as needed
//    private Long id;
//    private String customerName;
//    private String customerEmail;
//    private String customerPhone;
//    private String customerAddress;
//    @ElementCollection
//    private List<DispatchAsset> assets;
//
//    // Getters and setters
//}

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Entity
@Table(name = "dispatch_request")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DispatchRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DispatchAsset> assets = new ArrayList<>();


//@Override
//    public String toString() {
//        StringBuilder htmlInvoice = new StringBuilder();
//        htmlInvoice.append("<html>");
//        htmlInvoice.append("<body style=\"background-color:#e2e1e0;font-family: Open Sans, sans-serif;font-size:100%;font-weight:400;line-height:1.4;color:#000;\">");
//        htmlInvoice.append("<table style=\"max-width:670px;margin:50px auto 10px;background-color:#fff;padding:50px;-webkit-border-radius:3px;-moz-border-radius:3px;border-radius:3px;-webkit-box-shadow:0 1px 3px rgba(0,0,0,.12),0 1px 2px rgba(0,0,0,.24);-moz-box-shadow:0 1px 3px rgba(0,0,0,.12),0 1px 2px rgba(0,0,0,.24);box-shadow:0 1px 3px rgba(0,0,0,.12),0 1px 2px rgba(0,0,0,.24); border-top: solid 10px green;\">");
//
//        // Header
//        htmlInvoice.append("<thead>");
//        htmlInvoice.append("<tr>");
//        htmlInvoice.append("<th style=\"text-align:left;\"><img style=\"max-width: 150px;\" src=\"https://www.bachanatours.in/book/img/logo.png\" alt=\"bachana tours\"></th>");
//        htmlInvoice.append("<th style=\"text-align:right;font-weight:400;\">05th Apr, 2017</th>");
//        htmlInvoice.append("</tr>");
//        htmlInvoice.append("</thead>");
//
//        // Dispatch Status and Dispatch ID
//        htmlInvoice.append("<tr>");
//        htmlInvoice.append("<td colspan=\"2\" style=\"border: solid 1px #ddd; padding:10px 20px;\">");
//        htmlInvoice.append("<p style=\"font-size:14px;margin:0 0 6px 0;\"><span style=\"font-weight:bold;display:inline-block;min-width:150px\">Dispatch Status</span><b style=\"color:green;font-weight:normal;margin:0\">Success</b></p>");
//        htmlInvoice.append("<p style=\"font-size:14px;margin:0 0 6px 0;\"><span style=\"font-weight:bold;display:inline-block;min-width:146px\">Dispatch ID</span> abcd1234567890</p>");
//        htmlInvoice.append("</td>");
//        htmlInvoice.append("</tr>");
//
//        // Customer Information
//        htmlInvoice.append("<tr>");
//        htmlInvoice.append("<td style=\"width:50%;padding:20px;vertical-align:top\">");
//        htmlInvoice.append("<p style=\"margin:0 0 10px 0;padding:0;font-size:14px;\"><span style=\"display:block;font-weight:bold;font-size:13px\">Name</span> Palash Basak</p>");
//        htmlInvoice.append("<p style=\"margin:0 0 10px 0;padding:0;font-size:14px;\"><span style=\"display:block;font-weight:bold;font-size:13px;\">Email</span> palash@gmail.com</p>");
//        htmlInvoice.append("<p style=\"margin:0 0 10px 0;padding:0;font-size:14px;\"><span style=\"display:block;font-weight:bold;font-size:13px;\">Phone</span> +91-1234567890</p>");
//        htmlInvoice.append("<p style=\"margin:0 0 10px 0;padding:0;font-size:14px;\"><span style=\"display:block;font-weight:bold;font-size:13px;\">ID No.</span> 2556-1259-9842</p>");
//        htmlInvoice.append("</td>");
//
//        htmlInvoice.append("<td style=\"width:50%;padding:20px;vertical-align:top\">");
//        htmlInvoice.append("<p style=\"margin:0 0 10px 0;padding:0;font-size:14px;\"><span style=\"display:block;font-weight:bold;font-size:13px;\">Address</span> Khudiram Pally, Malbazar, West Bengal, India, 735221</p>");
//        htmlInvoice.append("<p style=\"margin:0 0 10px 0;padding:0;font-size:14px;\"><span style=\"display:block;font-weight-bold;font-size:13px;\">Number of guests</span> 2</p>");
//        htmlInvoice.append("<p style=\"margin:0 0 10px 0;padding:0;font-size:14px;\"><span style=\"display:block;font-weight:bold;font-size:13px;\">Duration of your vacation</span> 25/04/2017 to 28/04/2017 (3 Days)</p>");
//        htmlInvoice.append("</td>");
//        htmlInvoice.append("</tr>");
//
//        // Items
//        htmlInvoice.append("<tr>");
//        htmlInvoice.append("<td colspan=\"2\" style=\"font-size:20px;padding:30px 15px 0 15px;\">Items</td>");
//        htmlInvoice.append("</tr>");
//
//        // Asset Details
//        htmlInvoice.append("<tr>");
//        htmlInvoice.append("<td colspan=\"2\" style=\"padding:15px;\">");
//
//        // Sample asset details (you can loop through your assets)
//        htmlInvoice.append("<p style=\"font-size:14px;margin:0;padding:10px;border:solid 1px #ddd;font-weight:bold;\">");
//        htmlInvoice.append("<span style=\"display:block;font-size:13px;font-weight:normal;\">Homestay with fooding & lodging</span> Rs. 3500 <b style=\"font-size:12px;font-weight:300;\"> /person/day</b>");
//        htmlInvoice.append("</p>");
//
//        // Add more asset details here for each asset
//
//        htmlInvoice.append("</td>");
//        htmlInvoice.append("</tr>");
//
//        // Footer
//        htmlInvoice.append("<tfooter>");
//        htmlInvoice.append("<tr>");
//        htmlInvoice.append("<td colspan=\"2\" style=\"font-size:14px;padding:50px 15px 0 15px;\">");
//        htmlInvoice.append("<strong style=\"display:block;margin:0 0 10px 0;\">Regards</strong> Bachana Tours<br> Gorubathan, Pin/Zip - 735221, Darjeeling, West Bengal, India<br><br>");
//        htmlInvoice.append("<b>Phone:</b> 03552-222011<br>");
//        htmlInvoice.append("<b>Email:</b> contact@bachanatours.in");
//        htmlInvoice.append("</td>");
//        htmlInvoice.append("</tr>");
//        htmlInvoice.append("</tfooter>");
//
//        // Close the HTML structure
//        htmlInvoice.append("</table>");
//        htmlInvoice.append("</body>");
//        htmlInvoice.append("</html>");
//
//        return htmlInvoice.toString();
//    }

    LocalDate today = LocalDate.now();

    @Override
    public String toString() {
        StringBuilder htmlInvoice = new StringBuilder();
        htmlInvoice.append("<html>");
        htmlInvoice.append("<body style=\"background-color:#e2e1e0;font-family: Open Sans, sans-serif;font-size:100%;font-weight:400;line-height:1.4;color:#000;\">");
        htmlInvoice.append("<table style=\"max-width:670px;margin:50px auto 10px;background-color:#fff;padding:50px;-webkit-border-radius:3px;-moz-border-radius:3px;border-radius:3px;-webkit-box-shadow:0 1px 3px rgba(0,0,0,.12),0 1px 2px rgba(0,0,0,.24);-moz-box-shadow:0 1px 3px rgba(0,0,0,.12),0 1px 2px rgba(0,0,0,.24);box-shadow:0 1px 3px rgba(0,0,0,.12),0 1px 2px rgba(0,0,0,.24); border-top: solid 10px green;\">");

        // Header
        htmlInvoice.append("<thead>");
        htmlInvoice.append("<tr>");
        htmlInvoice.append("<th style=\"text-align:left;\"><img style=\"max-width: 150px;\" src=\"https://www.inventorymanagement.in/book/img/logo.png\" alt=\"logo\"></th>");
//        htmlInvoice.append("<th style=\"text-align:right;font-weight:400;\">05th Apr, 2017</th>");
        htmlInvoice.append("<th style=\"text-align:right;font-weight:400;\">").append(today).append("</th>");

        htmlInvoice.append("</tr>");
        htmlInvoice.append("</thead>");

        // Dispatch Status and Dispatch ID
        htmlInvoice.append("<tr>");
        htmlInvoice.append("<td colspan=\"2\" style=\"border: solid 1px #ddd; padding:10px 20px;\">");
        htmlInvoice.append("<p style=\"font-size:14px;margin:0 0 6px 0;\"><span style=\"font-weight:bold;display:inline-block;min-width:150px\">Dispatch Status</span><b style=\"color:green;font-weight:normal;margin:0\">Successful</b></p>");
        htmlInvoice.append("<p style=\"font-size:14px;margin:0 0 6px 0;\"><span style=\"font-weight:bold;display:inline-block;min-width:146px\">Dispatch ID</span>").append(id).append("</p>");
        htmlInvoice.append("</td>");
        htmlInvoice.append("</tr>");

        // Customer Information
        htmlInvoice.append("<tr>");
        htmlInvoice.append("<td style=\"width:50%;padding:20px;vertical-align:top\">");
        htmlInvoice.append("<p style=\"margin:0 0 10px 0;padding:0;font-size:14px;\"><span style=\"display:block;font-weight:bold;font-size:13px\">Name</span>").append(customerName).append("</p>");
        htmlInvoice.append("<p style=\"margin:0 0 10px 0;padding:0;font-size:14px;\"><span style=\"display:block;font-weight:bold;font-size:13px;\">Email</span>").append(customerEmail).append("</p>");
        htmlInvoice.append("<p style=\"margin:0 0 10px 0;padding:0;font-size:14px;\"><span style=\"display:block;font-weight:bold;font-size:13px;\">Phone</span>").append(customerPhone).append("</p>");
        htmlInvoice.append("<p style=\"margin:0 0 10px 0;padding:0;font-size:14px;\"><span style=\"display:block;font-weight:bold;font-size:13px;\">Address</span>").append(customerAddress).append("</p>");
        htmlInvoice.append("</td>");

        htmlInvoice.append("<td style=\"width:50%;padding:20px;vertical-align:top\">");
        // Additional customer information if needed
        htmlInvoice.append("</td>");
        htmlInvoice.append("</tr>");

        // Items
        htmlInvoice.append("<tr>");
        htmlInvoice.append("<td colspan=\"2\" style=\"font-size:20px;padding:30px 15px 0 15px;\">Items</td>");
        htmlInvoice.append("</tr>");

        // Asset Details
        htmlInvoice.append("<tr>");
        htmlInvoice.append("<td colspan=\"2\" style=\"padding:15px;\">");

        // Sample asset details (you can loop through your assets)
        for (DispatchAsset asset : assets) {
            htmlInvoice.append("<p style=\"font-size:14px;margin:0;padding:10px;border:solid 1px #ddd;font-weight:bold;\">");
            htmlInvoice.append("<span style=\"display:block;font-size:13px;font-weight:normal;\">").append(asset.getAssetName()).append("</span> QTY. ").append(asset.getQuantity()).append(" <b style=\"font-size:12px;font-weight:300;\"></b>");
            htmlInvoice.append("</p>");
        }

        // Add more asset details here for each asset

        htmlInvoice.append("</td>");
        htmlInvoice.append("</tr>");

        // Footer
        htmlInvoice.append("<tfooter>");
        htmlInvoice.append("<tr>");
        htmlInvoice.append("<td colspan=\"2\" style=\"font-size:14px;padding:50px 15px 0 15px;\">");
        htmlInvoice.append("<strong style=\"display:block;margin:0 0 10px 0;\">Regards</strong> Inventory Management<br> Prodapt Office, Pin/Zip - 600050, Chennai, Tamil Nadu, India<br><br>");
        htmlInvoice.append("<b>Phone:</b> 8825614225<br>");
        htmlInvoice.append("<b>Email:</b> contact@inventorymanagement.in");
        htmlInvoice.append("</td>");
        htmlInvoice.append("</tr>");
        htmlInvoice.append("</tfooter>");

        // Close the HTML structure
        htmlInvoice.append("</table>");
        htmlInvoice.append("</body>");
        htmlInvoice.append("</html>");

        return htmlInvoice.toString();
    }


// Getters and setters
}
