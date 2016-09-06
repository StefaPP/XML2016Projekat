<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:p="http://www.parlament.gov.rs/propisi" 
	>
	<xsl:template match="/">
		<html>
			<head>
				<style media="screen" type="text/css">
					body{
					margin-left: 15%;
					margin-right: 5%;
					font-size: 20px;
					}
					h,h1,h2,h3,h4,h5,h6{
					text-align: center;
					font-weight: bold;
					padding: 20;
					}
					h1.naslov{
					font-size: 37px;
					padding: 30px;
					}

					.meta_data{
					font-size: 20px;
					padding-top: 20px;
					text-align: right;
					}

					h1{
					font-size:32px;
					}

					h2{
					font-size: 30px;
					}

					h3{
					font-size: 28px;
					}

					h4{
					font-size: 26px;
					}

					h5{
					font-size: 24px;
					}

					h6{
					font-size: 22px;
					}
				</style>
			</head>
			<body>
				<h1 class="naslov">
					<xsl:value-of select=".//p:Meta_podaci/p:Naziv" />
				</h1>
				<xsl:apply-templates select="p:Akt/p:Glavni_deo" />
				<xsl:apply-templates select="p:Akt/p:Sporedni_deo" />
				<p class="meta_data">
					Status:
					<xsl:value-of select="p:Akt/@status" />
				</p>
			</body>
		</html>
	</xsl:template>

	

</xsl:stylesheet>