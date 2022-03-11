<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Конфеты</h2>
                <table border="1">
                    <tr bgcolor="#ffa500">
                        <th>Название</th>
                        <th>Калории</th>
                        <th>Тип</th>
                        <th>Сахар</th>
                        <th>Фруктоза</th>
                        <th>Ванилин</th>
                        <th>Белки</th>
                        <th>Жиры</th>
                        <th>Ушлеводы</th>
                        <th>Производство</th>
                    </tr>
                    <xsl:for-each select="Candy/candy">
                        <tr>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="energy"/></td>
                            <td><xsl:value-of select="type"/></td>
                            <td><xsl:value-of select="ingredients/shugar"/></td>
                            <td><xsl:value-of select="ingredients/fructose"/></td>
                            <td><xsl:value-of select="ingredients/vanillin"/></td>
                            <td><xsl:value-of select="values/proteins"/></td>
                            <td><xsl:value-of select="values/fats"/></td>
                            <td><xsl:value-of select="values/carbohydrates"/></td>
                            <td><xsl:value-of select="production"/></td>
                        </tr>
                    </xsl:for-each>

                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>