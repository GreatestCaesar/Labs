<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <table border="1">
                    <tr>
                        <th>Тип</th>
                        <th>Страна</th>
                        <th>Тип</th>
                        <th>Длина</th>
                        <th>Ширина</th>
                        <th>Материал</th>
                        <th>Коллекционный</th>
                    </tr>
                    <xsl:for-each select="FlatWare/flatware">
                        <tr>
                            <td><xsl:value-of select="type"/></td>
                            <td><xsl:value-of select="origin"/></td>
                            <td><xsl:value-of select="visual/type"/></td>
                            <td><xsl:value-of select="visual/length"/></td>
                            <td><xsl:value-of select="visual/width"/></td>
                            <td><xsl:value-of select="visual/material"/></td>
                            <td><xsl:value-of select="value"/></td>
                        </tr>
                    </xsl:for-each>

                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>