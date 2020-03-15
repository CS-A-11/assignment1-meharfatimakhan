#passes the train data and train labels as input and csv file format as output
##size is also passed

def convert(myImageFile, labelFile, outputFile, size):

    labelF = open(labelFile, "rb") ##image file parsed in bytes
    imageF = open(myImageFile, "rb") ##image file parsed in bytes
    output = open(outputFile, "w") ##write mode

    arrayI = []  ##create an array for images
    labelF.read(8) ##reads as 8 bytes
    imageF.read(16)##reads as 16 bytes

    for index in range(size):##for loop works till total size of data set
        readImg = [ord(labelF.read(1))]  ##returns an integer representing the Unicode code point
        for jIndex in range(28*28): ##we have total of 784 pixels
            readImg.append(ord(imageF.read(1))) ##we append the image with labels
        arrayI.append(readImg)##lastly add this in array

    for readImg in arrayI:##now write this to output file
        output.write(",".join(str(picture) for picture in readImg)+"\n")
    imageF.close()
    output.close()
    labelF.close()

convert("train-images.idx3-ubyte", "train-labels.idx1-ubyte",
        "mnist_train.csv", 60000)
convert("t10k-images.idx3-ubyte", "t10k-labels.idx1-ubyte",
        "mnist_test.csv", 10000)