package com.previsto.billy.mapping;

import com.previsto.billy.model.City;
import com.previsto.billy.model.Contact;
import com.previsto.billy.model.ZipCode;
import java.util.List;

public abstract class ContactMapping extends BaseMapping<Contact> {
 
    private List<City> cities;
    private List<ZipCode> zipcodes;


    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<ZipCode> getZipcodes() {
        return zipcodes;
    }

    public void setZipcodes(List<ZipCode> zipcodes) {
        this.zipcodes = zipcodes;
    }

    protected void resolveExtraData(Contact contact) {
        if (contact.getCityId() != null && getCities() != null) {
            for (City city : getCities()) {
                if (city.getId().equals(contact.getCityId())) {
                    contact.setCityText(city.getName());
                    contact.setCountryId(city.getCountryId());
                }
            }
        }
        if (contact.getZipcodeId() != null && getZipcodes() != null) {
            for (ZipCode zip : getZipcodes()) {
                if (zip.getId().equals(contact.getZipcodeId())) {
                    contact.setZipcodeText(zip.getZipcode());
                    contact.setCountryId(zip.getCountryId());
                }
            }
        }
    }
    
}
