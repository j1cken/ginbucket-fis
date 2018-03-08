package com.redhat;

import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;
import org.apache.camel.component.telegram.model.OutgoingPhotoMessage;

public class MyTransformerBean {

    public void transform(Exchange exchange) {
        OutgoingPhotoMessage msg = new OutgoingPhotoMessage();
        msg.setCaption(exchange.getIn().getBody(GenericFile.class).getFileNameOnly());
        msg.setFilenameWithExtension(msg.getCaption());
        msg.setPhoto(exchange.getIn().getBody(byte[].class));
        exchange.getIn().setBody(msg);
    }
}