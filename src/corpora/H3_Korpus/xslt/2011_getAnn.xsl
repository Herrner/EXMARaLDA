<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE TEI SYSTEM "http://xml.exmaralda.org/menota.dtd" [
<!--<!ENTITY % menota_entities SYSTEM
'http://xml.exmaralda.org/menota-entities.txt' >
%menota_entities;-->
<!ENTITY % h3_entities SYSTEM 'http://xml.exmaralda.org/h3-entities.txt'>
%h3_entities;
]>
<!-- change local-name() to name() or current-grouping-key()  for namespace-prefixes -->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:tei="http://www.tei-c.org/ns/1.0" xmlns:TEI="http://www.tei-c.org/ns/1.0"
	xmlns:me="http://www.menota.org/ns/1.0" version="2.0">
	<xsl:output method="html" encoding="UTF-8"/>
	<xsl:strip-space elements="*"/>
	<xsl:preserve-space elements="xml:text"/>
	<xsl:template match="/">
		<html>
			<head>
				<style type="text/css">
					body {
						font-size: 24px;
						font-family: "AndronScriptorWebRegular",
						"Andron Scriptor Web",
						"Arial Unicode",
						Serif;
						margin-left:3cm;
					}
					h1 {
						border-top: 1px dotted black;
						padding-top: 1em;
					}
					.clause {
						background-color: #ffffaa;
					}
					.phrase {
						background-color: #ffff00;
					}
					.highlight {
						border: 1px solid black;
					}
					.metadata {
						display: none;
					}
					.annotation {
						display: none;
					}
					.nav {
						background-color: #cccccc;
						border-radius: 10px;
					}
					@font-face {
						font-family: 'AndronScriptorWebRegular';
						src: url('http://www.exmaralda.org/fonts/andron_scriptor_web-webfont.eot');
						src: url('http://www.exmaralda.org/fonts/andron_scriptor_web-webfont.eot?iefix') format('eot'),
						url('http://www.exmaralda.org/fonts/andron_scriptor_web-webfont.woff') format('woff'),
						url('http://www.exmaralda.org/fonts/andron_scriptor_web-webfont.ttf') format('truetype'),
						url('http://www.exmaralda.org/fonts/andron_scriptor_web-webfont.svg#webfontjCZef2lu') format('svg');
						font-weight: normal;
						font-style: normal;
					}</style>

				<meta HTTP-EQUIV="content-type" CONTENT="text/html; charset=UTF-8"/>
				<title>
					<xsl:value-of select="//tei:title"/>
				</title>
				<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"/>
			</head>
			<body>
				<div class="nav" id="nav">
					<div>
						<button id="metadatabtn">Metadata</button>
						<button id="annotationbtn">Annotation</button>
					</div>
					<div class="metadata" id="metadata">
						<xsl:apply-templates select="//tei:teiHeader"/>
					</div>
					<div class="annotation" id="annotation"> word annotation: <xsl:for-each-group
							select="//tei:w/@*" group-by="name(.)">
							<xsl:if test="not(current-grouping-key()='part')">
								<xsl:value-of select="local-name()"/>:<select onchange="">
									<xsl:attribute name="name"><xsl:value-of select="local-name()"
										/></xsl:attribute>
									<option/>
									<xsl:for-each-group
										select="//tei:w/@*[name()=current-grouping-key()]"
										group-by=".">
										<option>
											<xsl:value-of select="current-grouping-key()"/>
										</option>
									</xsl:for-each-group>
								</select>
							</xsl:if>
						</xsl:for-each-group> italicaze 'ex': <input type="checkbox" name="ex"
							id="ex"/>
					</div>
				</div>
				<h1>
					<xsl:value-of select="//tei:titleStmt//tei:title[1]"/>
				</h1>

				<xsl:apply-templates select="//tei:text"/>
				<script>

  
$(document).ready(function(){
	$("div#nav").fadeTo("slow", 0.33);

	$("div#nav").hover(function(){
		$("div#nav").fadeTo("slow", 1);
	}, function() {
		$("div#nav").fadeTo("slow", 0.25);
	});

	$("button#metadatabtn").click(function() {
		$("div#metadata").slideToggle("slow");
	});
	$("button#annotationbtn").click(function() {
		$("div#annotation").slideToggle("slow");
	});
	

	$("span").hover(function(){
		if ($(this).attr('corresp')) {
			var target="[id='"+$(this).attr('corresp')+"']";
			$(this).addClass("highlight");
			$("html").find("span").filter($(target)).addClass("highlight");
		}
		},function(){
			$(this).removeClass("highlight");
			var target="[id='"+$(this).attr('corresp')+"']";
			$("html").find("span").filter($(target)).removeClass("highlight");
			});
	$("select").change(function () {
		$("span").css('background', '');
		var str = "";
		$("select option:selected").each(function () {
			if ($(this).text()!='') {
				str += "["+$(this).parent().attr("name") + "='" + $(this).text() + "']";
			}
		});
		$("html").find("span").filter($(str)).css('background', '#f0f');
	})
	
	$("input").change(function ()	{
		$(".ex").css('font-style','');
		if($('#ex').attr('checked') == true) {
				$(".ex").css('font-style','italic');
		} 
	});

});

				</script>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="tei:p">
		<p>
			<xsl:apply-templates/>
		</p>
	</xsl:template>
	<xsl:template match="tei:cl">
		<span onmouseover="this.className='clause';" onmouseout="this.className='';">
			<xsl:apply-templates/>
		</span>
	</xsl:template>
	<xsl:template match="tei:phr">
		<span onmouseover="this.className='phrase';" onmouseout="this.className='';">
			<xsl:apply-templates/>
		</span>
	</xsl:template>
	
	<xsl:template match="tei:w | tei:num | tei:name | tei:persName | tei:orgName">
		<span>
			<xsl:for-each select="@*">
				<xsl:attribute name="{local-name()}">
					<xsl:value-of select="."/>
				</xsl:attribute>
				<!--				<xsl:copy-of select="."/> -->
			</xsl:for-each>
			<xsl:attribute name="title">
				<xsl:for-each select="@*">
					<xsl:value-of select="./local-name()"/>
					<xsl:text>=</xsl:text>
					<xsl:value-of select="."/>
					<xsl:text>;</xsl:text>
				</xsl:for-each>
			</xsl:attribute>
			<xsl:apply-templates/>
		</span>
		<xsl:choose>
			<xsl:when test="following-sibling::*[1][self::me:punct]"/>
			<xsl:otherwise>
				<xsl:choose>
					<xsl:when test="following-sibling::*[1][self::tei:w][descendant::me:expunged]"/>
					<xsl:when
						test="not(following-sibling::*[1][self::tei:w]) and following-sibling::*[2][self::tei:w][descendant::me:expunged]"/>
					<xsl:otherwise>
						<xsl:text>&nbsp; </xsl:text>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	
	<xsl:template match="tei:ex">
		<span class="ex">
			<xsl:apply-templates/>
		</span>
	</xsl:template>
	
	<xsl:template match="me:punct">
		<xsl:apply-templates/>
		<xsl:text>&nbsp;</xsl:text>
	</xsl:template>
	
	
	<!-- teiHeader-Templates -->
	<xsl:template match="tei:teiHeader">
		<h3><xsl:value-of select="//tei:title"/> (<xsl:value-of select="//tei:idno"/>)</h3>
		<xsl:if test="count(//tei:bibl)>0">
			<h4>
				<xsl:value-of select="//tei:bibl"/>
			</h4>
		</xsl:if>
		<xsl:apply-templates/>
	</xsl:template>


	<xsl:template match="tei:fileDesc">
		<span>
			<xsl:attribute name="class">fileDesc</xsl:attribute>
			<h1><xsl:value-of select="tei:titleStmt/tei:title"/></h1>
			<p><xsl:value-of select="tei:publicationStmt//tei:p"/>
				<xsl:value-of select="tei:sourceDesc/tei:p"/></p>
		</span>
	</xsl:template>
	
	
	<xsl:template match="tei:revisionDesc">
		<span>
			<xsl:attribute name="class">revisionDesc</xsl:attribute>
			<ul><xsl:apply-templates/></ul>
		</span>
	</xsl:template>
	
	
	<xsl:template match="tei:change">
		<li><xsl:value-of select="."/></li>
	</xsl:template>
	
	
</xsl:stylesheet>
