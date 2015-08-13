<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output method="html" encoding="UTF-8"/>
	<xsl:template match="/">
		<html>
			<head>
				<style type="text/css" media="screen">
					th {text-align:left}
					td.CHILD {font-size:11pt}
					td.INT {font-size:9pt}
					td.comment{border:none; font-size:8pt; color:rgb(0,0,200); background-color:rgb(222,222,222)}
					td.odd {background-color:rgb(200,200,200)}
				</style>
			</head>
			<body>
				<h1>Meta-Information</h1>
				<table>
					<xsl:apply-templates select="//ud-meta-information/ud-information"/>
				</table>
				<h1>Transcription</h1>
				<table>
					<colgroup>
						<col width="250px"/>
						<col width="150px"/>
						<col width="250px"/>
					</colgroup>
					<tr>
						<th>CHILD</th>
						<th>INTERVIEWER</th>
						<th>COMMENT</th>
					</tr>
					<xsl:for-each select="//tli">
						<tr>
							<td class="CHILD">
								<xsl:value-of select="//tier[@id='TIE0']/event[@start=current()/@id]"/>
							</td>
							<td class="INT">
								<xsl:value-of select="//tier[@id='TIE1']/event[@start=current()/@id]"/>								
							</td>
							<xsl:choose>
								<xsl:when test="//tier[@id='TIE2']/event[@start=current()/@id]">
									<xsl:element name="td">
										<xsl:attribute name="class">comment</xsl:attribute>
										<xsl:attribute name="rowspan">
											<xsl:choose>
												<xsl:when test="//tier[@id='TIE1']/event[@start=current()/following-sibling::tli[1]/@id]">2</xsl:when>
												<xsl:otherwise>1</xsl:otherwise>
											</xsl:choose>											
										</xsl:attribute>
										<xsl:value-of select="//tier[@id='TIE2']/event[@start=current()/@id]"/>																		
									</xsl:element>
								</xsl:when>
							</xsl:choose>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="ud-information">
		<tr>
			<xsl:element name="td">
				<xsl:attribute name="class">attName
					<xsl:choose>
						<xsl:when test="position() mod 2 = 0"> even</xsl:when>
						<xsl:otherwise> odd</xsl:otherwise>
					</xsl:choose>
				</xsl:attribute>
				<xsl:value-of select="@attribute-name"/>
			</xsl:element>
			<xsl:element name="td">
				<xsl:attribute name="class">attValue
					<xsl:choose>
						<xsl:when test="position() mod 2 = 0"> even</xsl:when>
						<xsl:otherwise> odd</xsl:otherwise>
					</xsl:choose>
				</xsl:attribute>
				<xsl:value-of select="text()"/>
				
			</xsl:element>
		</tr>
	</xsl:template>
</xsl:stylesheet>
