package com.example.SeleniumCleverbotTests.Utils;

import com.example.SeleniumCleverbotTests.Utils.Model.Email;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public class MailingService {
    private RequestSpecification requestSpecification;

    public MailingService() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://privatix-temp-mail-v1.p.rapidapi.com")
                .setBasePath("/request")
                .addHeader("x-rapidapi-host", "privatix-temp-mail-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "074c6d9b44mshad92a00bd4e3c6ap11706cjsn24fb3bebf131")
                .build();
    }

    public Map<Object, Object> createNewMail(String name) {
        Response apiResponse = given(requestSpecification)
                .param("action", "new")
                .param("name", name)
                .param("type", "json")
                .get();
        Map<Object, Object> emailKey = apiResponse.getBody().jsonPath().get();


        return emailKey;
    }

    public List<String> getDomains() {
        Response apiResponse = given(requestSpecification)
                .get("/domains/");
        String domainsResponse = apiResponse.getBody().asString()
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .replaceAll("\\\"", "");
        List domainsList = Arrays.asList(domainsResponse.split("\\s*,\\s*"));
        return domainsList;
    }

    public String generateEmail(String username) {
        List<String> domainsList = getDomains();
        String mailWithDomain = username + domainsList.get(0);
        return mailWithDomain;
    }

    public String hashEmailToMd5(String email) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(email.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toLowerCase();
    }

    public Email[] getEmails(String email) {
        int iterations = 5;
        String hashedEmail = "";
        try {
            hashedEmail = hashEmailToMd5(email);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Email[] emailData = given(requestSpecification)
                .get("/mail/id/" + hashedEmail + "/")
                .getBody()
                .jsonPath()
                .getObject("$", Email[].class);

        return emailData;
    }

    public List<String> getVerificationLink(String email) {
        Email[] emailContent = getEmails(email);
        ArrayList<String> links = new ArrayList();
        String regex = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&@#/%=~_()|]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(emailContent[0].getMailTextOnly());
        while (m.find()) {
            String urlStr = m.group();
            if (urlStr.startsWith("(") && urlStr.endsWith(")")) {
                urlStr = urlStr.substring(1, urlStr.length() - 1);
            }
            links.add(urlStr);
        }
        return links;
    }

}
