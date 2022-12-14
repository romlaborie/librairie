package com.epsiBibliProjet.librairie.dto;

import com.epsiBibliProjet.librairie.enumator.Format;
import com.epsiBibliProjet.librairie.enumator.Language;

import java.util.List;

public record BookItemDto(String rfid, String barcode, Language language, int numberOfPages, Format format, String isbn) {
}
