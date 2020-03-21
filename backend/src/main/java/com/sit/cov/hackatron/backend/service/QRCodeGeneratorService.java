package com.sit.cov.hackatron.backend.service;

import java.io.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.google.zxing.*;
import com.google.zxing.client.j2se.*;
import com.google.zxing.common.BitMatrix;
import reactor.core.publisher.Mono;

@Service
public class QRCodeGeneratorService {

    public Mono<byte[]> generateQRCode(String text, int width, int height) {

        Assert.hasText(text, "text must not be empty");
        Assert.isTrue(width > 0, "width must be greater than zero");
        Assert.isTrue(height > 0, "height must be greater than zero");

        return Mono.create(image -> {
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                BitMatrix matrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height);
                MatrixToImageWriter.writeToStream(matrix, MediaType.IMAGE_PNG.getSubtype(), baos,
                        new MatrixToImageConfig());
                image.success(baos.toByteArray());
            } catch (IOException | WriterException ex) {
                image.error(ex);
            }
        });
    }
}