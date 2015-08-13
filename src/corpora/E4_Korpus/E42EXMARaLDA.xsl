<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" method="xml"/>
	<xsl:template match="/">
		<basic-transcription>
			<head>
				<meta-information>
					<project-name>E4: Spezifische Sprachentwicklungsstörung und früher L2-Erwerb:
						Zur Differenzierung von Abweichungen im Grammatikerwerb</project-name>
					<transcription-name/>
					<xsl:element name="referenced-file">
						<xsl:attribute name="url">
							<!-- videoPfad: "Tranaly01:Transkription:Videos:EB_30052003_01_09.mov -->
							<xsl:value-of
								select="substring-after(//meta[@attribute='videoPfad'], 'Videos:')"
							/>
						</xsl:attribute>
					</xsl:element>
					<ud-meta-information>
						<xsl:apply-templates select="//meta"/>
					</ud-meta-information>
					<comment/>
					<transcription-convention>E4</transcription-convention>
				</meta-information>
				<speakertable>
					<speaker id="CHI">
						<abbreviation>
							<xsl:value-of select="substring(//meta[@attribute='child'],1,3)"/>
						</abbreviation>
						<sex value="u"/>
						<languages-used/>
						<l1/>
						<l2/>
						<ud-speaker-information>
							<ud-information attribute-name="Name">
								<xsl:value-of select="//meta[@attribute='child']/text()"/>
							</ud-information>
						</ud-speaker-information>

						<comment/>
					</speaker>
					<xsl:for-each select="//meta[@attribute='interviewer']">
						<speaker id="INT">
							<abbreviation>
								<!--								<xsl:value-of select="substring(translate(translate(.,' ',''),'.',''),1,3)"/>-->
								<xsl:value-of select="substring(.,1,3)"/>
							</abbreviation>
							<sex value="u"/>
							<languages-used/>
							<l1/>
							<l2/>
							<ud-speaker-information>
								<ud-information attribute-name="Name">
									<xsl:value-of select="."/>
								</ud-information>
							</ud-speaker-information>

							<comment/>
						</speaker>
					</xsl:for-each>
				</speakertable>
			</head>
			<body>
				<common-timeline>
					<xsl:for-each select="//dataset">
						<xsl:element name="tli">
							<xsl:attribute name="id">
								<xsl:text>T</xsl:text>
								<xsl:value-of select="@no"/>
								<xsl:text>S</xsl:text>
							</xsl:attribute>
							<xsl:attribute name="time">
								<xsl:choose>
									<xsl:when test="position()!=1">
										<xsl:value-of
											select="(preceding-sibling::*[1]/@start) div 10"/>
									</xsl:when>
									<xsl:otherwise>0.0</xsl:otherwise>
								</xsl:choose>
							</xsl:attribute>
						</xsl:element>
						<xsl:if test="string-length(context/text())&gt;0">
							<xsl:element name="tli">
								<xsl:attribute name="id">
									<xsl:text>T</xsl:text>
									<xsl:value-of select="@no"/>
									<xsl:text>E</xsl:text>
								</xsl:attribute>
							</xsl:element>
						</xsl:if>
					</xsl:for-each>
					<xsl:element name="tli">
						<xsl:attribute name="id">
							<xsl:text>TS</xsl:text>
						</xsl:attribute>
					</xsl:element>
				</common-timeline>
				<xsl:element name="tier">
					<xsl:attribute name="id">TIE3</xsl:attribute>
					<xsl:attribute name="speaker">CHI</xsl:attribute>
					<xsl:attribute name="category">utt</xsl:attribute>
					<xsl:attribute name="type">a</xsl:attribute>
					<xsl:attribute name="display-name"/>
					<xsl:for-each select="//dataset/utterance">
						<xsl:element name="event">
							<xsl:attribute name="start">
								<xsl:text>T</xsl:text>
								<xsl:value-of select="../@no"/>
								<xsl:text>S</xsl:text>
							</xsl:attribute>
							<xsl:attribute name="end">
								<xsl:choose>
									<xsl:when test="string-length(../context/text())&gt;0">
										<xsl:text>T</xsl:text>
										<xsl:value-of select="../@no"/>
										<xsl:text>E</xsl:text>
									</xsl:when>
									<xsl:otherwise>
										<xsl:text>T</xsl:text>
										<xsl:value-of select="../following-sibling::dataset/@no"/>
										<xsl:text>S</xsl:text>
									</xsl:otherwise>
								</xsl:choose>
							</xsl:attribute>
							<xsl:value-of select="../@no"/>
						</xsl:element>
					</xsl:for-each>
				</xsl:element>
				<xsl:element name="tier">
					<xsl:attribute name="id">TIE0</xsl:attribute>
					<xsl:attribute name="speaker">CHI</xsl:attribute>
					<xsl:attribute name="category">v</xsl:attribute>
					<xsl:attribute name="type">t</xsl:attribute>
					<xsl:attribute name="display-name">CHI [v]</xsl:attribute>
					<xsl:for-each select="//dataset/utterance">
						<xsl:element name="event">
							<xsl:attribute name="start">
								<xsl:text>T</xsl:text>
								<xsl:value-of select="../@no"/>
								<xsl:text>S</xsl:text>
							</xsl:attribute>
							<xsl:attribute name="end">
								<xsl:choose>
									<xsl:when test="string-length(../context/text())&gt;0">
										<xsl:text>T</xsl:text>
										<xsl:value-of select="../@no"/>
										<xsl:text>E</xsl:text>
									</xsl:when>
									<xsl:otherwise>
										<xsl:text>T</xsl:text>
										<xsl:value-of select="../following-sibling::dataset/@no"/>
										<xsl:text>S</xsl:text>
									</xsl:otherwise>
								</xsl:choose>
							</xsl:attribute>
							<xsl:value-of select="text()"/>
						</xsl:element>
					</xsl:for-each>
				</xsl:element>
				<xsl:element name="tier">
					<xsl:attribute name="id">TIE1</xsl:attribute>
					<xsl:attribute name="speaker">INT</xsl:attribute>
					<xsl:attribute name="category">v</xsl:attribute>
					<xsl:attribute name="type">t</xsl:attribute>
					<xsl:attribute name="display-name">INT [v]</xsl:attribute>
					<xsl:for-each select="//dataset/context[string-length(text())&gt;0]">
						<xsl:element name="event">
							<xsl:attribute name="start">
								<xsl:text>T</xsl:text>
								<xsl:value-of select="../@no"/>
								<xsl:text>E</xsl:text>
							</xsl:attribute>
							<xsl:attribute name="end">
								<xsl:text>T</xsl:text>
								<xsl:value-of select="../following-sibling::dataset/@no"/>
								<xsl:text>S</xsl:text>
							</xsl:attribute>
							<xsl:value-of select="text()"/>
						</xsl:element>
					</xsl:for-each>
				</xsl:element>
				<xsl:element name="tier">
					<xsl:attribute name="id">TIE2</xsl:attribute>
					<xsl:attribute name="speaker"/>
					<xsl:attribute name="category">c</xsl:attribute>
					<xsl:attribute name="type">d</xsl:attribute>
					<xsl:attribute name="display-name"/>
					<xsl:for-each select="//dataset/comment[string-length(text())&gt;0]">
						<xsl:element name="event">
							<xsl:attribute name="start">
								<xsl:text>T</xsl:text>
								<xsl:value-of select="../@no"/>
								<xsl:text>S</xsl:text>
							</xsl:attribute>
							<xsl:attribute name="end">
								<xsl:text>T</xsl:text>
								<xsl:value-of select="../following-sibling::dataset/@no"/>
								<xsl:text>S</xsl:text>
							</xsl:attribute>
							<xsl:value-of select="text()"/>
						</xsl:element>
					</xsl:for-each>
				</xsl:element>
			</body>
		</basic-transcription>
	</xsl:template>

	<xsl:template match="meta">
		<xsl:element name="ud-information">
			<xsl:attribute name="attribute-name">
				<xsl:value-of select="@attribute"/>
			</xsl:attribute>
			<xsl:value-of select="text()"/>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>
