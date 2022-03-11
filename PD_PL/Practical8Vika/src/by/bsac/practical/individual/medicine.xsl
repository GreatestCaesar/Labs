<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <table border="1">
                    <tr bgcolor="#800080">
                        <th>Наименование</th>
                        <th>Фирма</th>
                        <th>Группа</th>
                        <th>Аналоги</th>
                        <th>Вид</th>
                        <th>Свидетельство</th>
                        <th>Упаковка</th>
                        <th>Дозировка</th>
                    </tr>
                    <xsl:for-each select="Medicine/drug">
                        <tr>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="pharm"/></td>
                            <td><xsl:value-of select="group"/></td>
                            <td><xsl:value-of select="analogs"/></td>
                            <td><xsl:value-of select="versions"/></td>
                            <td><xsl:value-of select="certificate"/></td>
                            <td><xsl:value-of select="package"/></td>
                            <td><xsl:value-of select="dosage"/></td>
                        </tr>
                    </xsl:for-each>

                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>