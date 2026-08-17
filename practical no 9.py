import os
import sys

# Set Java 17
JAVA_HOME = r"C:\Program Files\Eclipse Adoptium\jdk-17.0.20.8-hotspot"

os.environ["JAVA_HOME"] = JAVA_HOME
os.environ["PATH"] = JAVA_HOME + r"\bin;" + os.environ["PATH"]

# Tell PySpark to use the current Python
os.environ["PYSPARK_PYTHON"] = sys.executable
os.environ["PYSPARK_DRIVER_PYTHON"] = sys.executable

# Import SparkSession
from pyspark.sql import SparkSession

# Create Spark session
spark = SparkSession.builder \
    .appName("WordCount") \
    .master("local[2]") \
    .getOrCreate()

# Hide Spark warnings
spark.sparkContext.setLogLevel("ERROR")

# Read input.txt from the same folder
input_file = os.path.join(
    os.path.dirname(os.path.abspath(__file__)),
    "input.txt"
)

text_file = spark.sparkContext.textFile(input_file)

# Count frequency of each word
word_counts = (
    text_file
    .flatMap(lambda line: line.split())
    .map(lambda word: (word.lower(), 1))
    .reduceByKey(lambda a, b: a + b)
)

# Display result
print()
print("======================================")
print("           WORD COUNT RESULT")
print("======================================")

for word, count in sorted(word_counts.collect()):
    print(word, ":", count)

print("======================================")

# Stop Spark
spark.stop()