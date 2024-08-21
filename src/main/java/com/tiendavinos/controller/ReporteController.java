package com.tiendavinos.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiendavinos.model.DetallePedido;
import com.tiendavinos.repository.IDetallePedidoRepository;

@Controller
@RequestMapping("/exportarReporteVentas")
public class ReporteController {
    
    private final IDetallePedidoRepository detallePedidoRepository;
    
    // Constructor para inyectar el repositorio
    public ReporteController(IDetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    @GetMapping
    public ResponseEntity<InputStreamResource> exportarReporteVentas() throws IOException {
        // Generar reporte en formato Excel
        ByteArrayInputStream in = generateExcelReport();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=detalle_pedidos.xlsx");

        return new ResponseEntity<>(new InputStreamResource(in), headers, HttpStatus.OK);
    }

    private ByteArrayInputStream generateExcelReport() throws IOException {
        List<DetallePedido> detalles = detallePedidoRepository.findAll();
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Detalle Pedidos");

        // Crear encabezado
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("IdDetallePedido");
        headerRow.createCell(1).setCellValue("Nombre");
        headerRow.createCell(2).setCellValue("Cantidad");
        headerRow.createCell(3).setCellValue("Precio");
        headerRow.createCell(4).setCellValue("Total");

        // Llenar datos
        int rowNum = 1;
        for (DetallePedido detalle : detalles) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(detalle.getIdDetallePedido());
            row.createCell(1).setCellValue(detalle.getNombre()); 
            row.createCell(2).setCellValue(detalle.getCantidad());
            row.createCell(3).setCellValue(detalle.getPrecio());
            row.createCell(4).setCellValue(detalle.getCantidad() * detalle.getPrecio());
        }

        // Autoajustar ancho de columnas
        for (int i = 0; i < 5; i++) {
            sheet.autoSizeColumn(i);
        }

        // Convertir a ByteArrayInputStream
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } finally {
            workbook.close();
        }
    }
}
