package export

import model.GradeResult
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileOutputStream

class ExcelExporter {

    fun export(results: List<GradeResult>, output: File) {

        val workbook = XSSFWorkbook()
        val sheet = workbook.createSheet("Grades")

        // Header row
        val header = sheet.createRow(0)
        header.createCell(0).setCellValue("Student Name")
        header.createCell(1).setCellValue("Grade")

        var rowIndex = 1

        for (result in results) {

            val row = sheet.createRow(rowIndex)

            row.createCell(0).setCellValue(result.studentName)

            // Convert grades map to text
            val gradeText = result.grades.values.joinToString(", ")
            row.createCell(1).setCellValue(gradeText)

            rowIndex++
        }

        // Auto-size columns
        sheet.autoSizeColumn(0)
        sheet.autoSizeColumn(1)

        val fileOut = FileOutputStream(output)
        workbook.write(fileOut)

        fileOut.close()
        workbook.close()
    }
}