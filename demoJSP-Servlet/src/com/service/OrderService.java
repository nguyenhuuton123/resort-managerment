package com.service;

import com.entity.Contract;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.util.List;

public class OrderService {
    public static void ghiContractVaoFile(List<Contract> contractList) {
        try {
            // Mở file Excel hiện có
            File inp = new File("statical.xls");
            Workbook existingWorkbook = Workbook.getWorkbook(inp);

            // Tạo một bản sao có thể ghi được từ Workbook hiện có
            File out = new File("statical.xls");
            WritableWorkbook workbook = Workbook.createWorkbook(out, existingWorkbook);

            // Lấy sheet đầu tiên
            WritableSheet sheet = workbook.getSheet(0);

            // Ghi dữ liệu
            for (int i = 0; i < contractList.size(); i++) {
                Contract contract = contractList.get(i);
                Label name = new Label(0, i + 1, String.valueOf(contract.getId()));
                Label StartDate = new Label(1, i + 1, String.valueOf(contract.getStartDate()));
                Label EndDate = new Label(2, i + 1, String.valueOf(contract.getEndDate()));
                Label EmployeeId = new Label(2, i + 1, String.valueOf(contract.getEmployeeId()));
                Label FacilityId = new Label(2, i + 1, String.valueOf(contract.getFacilityId()));
                Label Deposit = new Label(2, i + 1, String.valueOf(contract.getDeposit()));
                sheet.addCell(name);
                sheet.addCell(StartDate);
                sheet.addCell(EndDate);
                sheet.addCell(EmployeeId);
                sheet.addCell(FacilityId);
                sheet.addCell(Deposit);
            }

            // Đóng Workbook hiện có trước khi ghi bản sao
            existingWorkbook.close();

            // Ghi workbook vào file và đóng nó
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            System.out.println("bug");
        }
    }
}
