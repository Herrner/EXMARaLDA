<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:pers="http://www.exmaralda.org" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xdt="http://www.w3.org/2005/xpath-datatypes" version="2.0">
	<xsl:template match="/">
		<html>
		<head>
			<xsl:call-template name="generate-styles"></xsl:call-template>
		</head>
		<body>
		<xsl:for-each-group select="//speaker" group-by="@sigle">
			<xsl:sort select="@sigle"/>
				<h1>
					<xsl:value-of select="current-grouping-key()"/>		
					<xsl:text> (</xsl:text>
					<xsl:value-of select="//Speaker[Sigle=current-grouping-key()]/Description/Key[@Name='Status']"/>												
					<xsl:text>)</xsl:text>
				</h1>
			<table>
				<colgroup>
					<col width="80px"/>
					<col width="80px"/>
					<col width="80px"/>
					<col width="80px"/>
					<col width="80px"/>
					<col width="80px"/>
					<col width="80px"/>
				</colgroup>
				<tr>
					<th>Comm</th>
					<th>Trans</th>
					<th>Contr</th>
					<th>Utterances</th>
					<th>Words</th>
					<th>MLU</th>
					<th>Non-Pho</th>
				</tr>
				<xsl:for-each-group select="current-group()" group-by="../@communication-id">
					<xsl:sort select="../@communication-id"/>
					<xsl:for-each select="current-group()">
						<xsl:sort select="../@transcription-name"/>
						<tr>
							<td> </td>
							<td>
								<xsl:value-of select="../@transcription-name"/>
							</td>
							<td>
								<xsl:value-of select="count[@segment-name='Speaker Contributions']/@count"/>
							</td>
							<td>
								<xsl:value-of select="count[@segment-name='Utterances']/@count"/>
							</td>
							<td>
								<xsl:value-of select="count[@segment-name='Words']/@count"/>
							</td>
							<td>
								<xsl:value-of select="round(100*(count[@segment-name='Words']/@count div count[@segment-name='Utterances']/@count)) div 100"/>
							</td>
							<td>
								<xsl:value-of
									select="count[@segment-name='Non-Phonological']/@count"/>
							</td>
						</tr>
					</xsl:for-each>
					<tr>
						<td class="total">
							<!--<xsl:value-of select="current-grouping-key()"/>-->
							<xsl:value-of select="//Communication[@Id=current-grouping-key()]/@Name"></xsl:value-of>
						</td>
						<td></td>
						<td class="total">
							<xsl:value-of select="sum(current-group()/count[@segment-name='Speaker Contributions']/@count)"></xsl:value-of>
						</td>
						<td class="total">
							<xsl:value-of select="sum(current-group()/count[@segment-name='Utterances']/@count)"></xsl:value-of>
						</td>
						<td class="total">
							<xsl:value-of select="sum(current-group()/count[@segment-name='Words']/@count)"></xsl:value-of>
						</td>
						<td class="total">
							<xsl:value-of select="round(100*sum(current-group()/count[@segment-name='Words']/@count) div sum(current-group()/count[@segment-name='Utterances']/@count)) div 100"></xsl:value-of>
						</td>
						<td class="total">
							<xsl:value-of select="sum(current-group()/count[@segment-name='Non-Phonological']/@count)"></xsl:value-of>
						</td>
					</tr>
				</xsl:for-each-group>
				<tr>
					<td class="totaltotal">
						Total
					</td>
					<td></td>
					<td class="totaltotal">
						<xsl:value-of select="sum(current-group()/count[@segment-name='Speaker Contributions']/@count)"></xsl:value-of>
					</td>
					<td class="totaltotal">
						<xsl:value-of select="sum(current-group()/count[@segment-name='Utterances']/@count)"></xsl:value-of>
					</td>
					<td class="totaltotal">
						<xsl:value-of select="sum(current-group()/count[@segment-name='Words']/@count)"></xsl:value-of>
					</td>
					<td class="totaltotal">
						<xsl:value-of select="round(100*sum(current-group()/count[@segment-name='Words']/@count) div sum(current-group()/count[@segment-name='Utterances']/@count)) div 100"></xsl:value-of>
					</td>
					<td class="totaltotal">
						<xsl:value-of select="sum(current-group()/count[@segment-name='Non-Phonological']/@count)"></xsl:value-of>
					</td>
					<td> </td>
				</tr>
			</table>
		</xsl:for-each-group>
		</body>
		</html>
	</xsl:template>
	
	<xsl:template name="generate-styles">
		<style type="text/css">
			th {background-color:rgb(100,100,100);border-width:1px; color:white; padding-right:5px}
			td {border-style:solid;border-width:1px;  text-align:right; padding-right:5px;vertical-align:top}
			td.total {font-weight:bold; background-color:rgb(200,200,200); padding-right:5px}
			td.totaltotal {font-weight:bold; background-color:rgb(200,0,0); padding-right:5px}
			h1 {font-size:12pt}
		</style>
	</xsl:template>
</xsl:stylesheet>
