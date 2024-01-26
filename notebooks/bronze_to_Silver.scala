// Databricks notebook source
// MAGIC %md
// MAGIC ##Conferindo se os dados foram montados e se temos acesso a pasta bronze

// COMMAND ----------

// MAGIC %python
// MAGIC dbutils.fs.ls("/mnt/dados/bronze/")

// COMMAND ----------

val path ="dbfs:/mnt/dados/bronze/dataset_imoveis/"
val dados = spark.read.format("delta").load(path)

// COMMAND ----------

display(dados)

// COMMAND ----------

// MAGIC %md
// MAGIC #Transformando os campos do json em colunas

// COMMAND ----------

display(dados.select("anuncio.*"))

// COMMAND ----------

display(dados.select("anuncio.*","anuncio.endereco.*"))

// COMMAND ----------

val dados_detalhados=dados.select("anuncio.*","anuncio.endereco.*")

// COMMAND ----------

val df_silver = dados_detalhados.drop("caracteristicas","endereco")
display(df_silver)

// COMMAND ----------

val path ="dbfs:/mnt/dados/silver/dataset_imoveis"
df_silver.write.format("delta").mode(SaveMode.Overwrite).save(path)

// COMMAND ----------


