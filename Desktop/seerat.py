import matplotlib.pyplot as plt
from scipy.fftpack import fft, fftfreq
from datetime import datetime
import numpy as np
import wave
import sys
import scipy.io.wavfile
from tkinter import *
from tkinter import filedialog
import tkinter as Tk
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
from matplotlib.figure import Figure
import contextlib


def GetTime(secs):
    mins, secs = divmod(secs, 60)
    hours, mins = divmod(mins, 60)
    return '%02d:%02d:%02d' % (hours, mins, secs)


def Plot(event, frame1, frame2, window, slider1, TimeD):  # plot the audio signal here

    # if(window.file!=0):

    filename = filedialog.askopenfilename(filetypes=(("Wave files", "*.wav"), ("All files", "*.*")))

    val = slider1.get();  # get slider value;
    if (filename != '' and filename != 0):
        TimeD.delete('0', END)
        with contextlib.closing(wave.open(filename, 'r')) as f:
            frames = f.getnframes()
            rates = f.getframerate()
            duration = frames / float(rates)
            hours = 0
            minutes = 0
            seconds = duration
            time = GetTime(duration)
        TimeD.insert('0', time)
        frame1.destroy()
        frame2.destroy()
        frame1 = Frame(window, borderwidth=1, relief="solid", width=500, height=380)
        frame1.grid(row=0, column=50)
        frame1.pack_propagate(0)
        frame2 = Frame(window, borderwidth=1, relief="solid", width=500, height=380)
        frame2.grid(row=0, column=150, padx=10)
        frame2.pack_propagate(0)

        window.file = filename
        rate, data = scipy.io.wavfile.read(filename, 'rb')
        fig = Figure(figsize=(8, 8), dpi=40)
        a = fig.add_subplot(111)
        a.set_ylabel('Amplitude')
        min = 0
        if (val != 0):
            min = rate / (val)

        a.set_xlim(min, rate * (val + 1))

        a.plot(data)
        canvas = FigureCanvasTkAgg(fig, master=frame1)
        canvas.draw()
        canvas.get_tk_widget().pack(padx=100, pady=20, side=LEFT, expand=True)


def ChangePlot(event, frame1, Parent, slider1, filename):  # plot the audio signal here

    if (window.file != 0 and window.file != ''):
        # filename=filedialog.askopenfilename(filetypes=(("Wave files","*.wav"),("All files","*.*")))
        val = slider1.get();  # get slider value;

        frame1.destroy()
        frame1 = Frame(Parent, borderwidth=1, relief="solid", width=500, height=380)
        frame1.grid(row=0, column=50)
        frame1.pack_propagate(0)
        window.file = filename
        rate, data = scipy.io.wavfile.read(filename, 'rb')
        fig = Figure(figsize=(8, 8), dpi=40)
        a = fig.add_subplot(111)
        a.set_ylabel('Amplitude')
        min = 0
        if (val != 0):
            min = rate / (val)

        a.set_xlim(min, rate * (val + 1))

        a.plot(data)
        canvas = FigureCanvasTkAgg(fig, master=frame1)
        canvas.draw()
        canvas.get_tk_widget().pack(padx=100, pady=20, side=LEFT, expand=True)


def FFTPlot(event, frame1, Parent, filename, slider2):
    if (window.file != 0 and window.file != ''):
        samplerate, data = scipy.io.wavfile.read(filename, 'rb')
        samples = data.shape[0]
        datafft = fft(data)
        fftabs = abs(datafft)

        frame1.destroy()
        frame1 = Frame(Parent, borderwidth=1, relief="solid", width=500, height=380)
        frame1.grid(row=0, column=150, padx=10)
        frame1.pack_propagate(0)
        freqs = fftfreq(samples, 1 / samplerate)

        fig = Figure(figsize=(8, 8), dpi=40)
        a = fig.add_subplot(111)
        a.set_ylabel('Imaginary')
        a.set_xlabel('Frequency')
        val = slider2.get();
        min = 0
        if (val != 0):
            min = samplerate / (2 + (4 - val))

        a.set_xlim(min, samplerate / (2 + (4 - val - 1)))
        a.plot(freqs[:int(freqs.size / 2)], fftabs[:int(freqs.size / 2)])

        canvas = FigureCanvasTkAgg(fig, master=frame1)
        canvas.draw()
        canvas.get_tk_widget().pack(fill=BOTH, padx=100, pady=20, side=LEFT, expand=True)


def main():
    window.title('Audio')
    window.geometry("1100x500")
    window.pack_propagate(0)
    file = "0"

    frame1 = Frame(window, borderwidth=1, relief="solid", width=500, height=380)
    frame1.grid(row=0, column=50)
    frame1.pack_propagate(0)
    frame2 = Frame(window, borderwidth=1, relief="solid", width=500, height=380)
    frame2.grid(row=0, column=150, padx=10)
    frame2.pack_propagate(0)
    bottomframe = Frame(window)
    bottomframe.pack(side=BOTTOM)
    button1 = Button(bottomframe, text="Upload", fg="black", bg="silver")
    button1.pack(padx=100, pady=20, side=LEFT)
    Duration = Label(bottomframe, text="Duration")
    Duration.pack(padx=10, side=LEFT)
    TimeD = Entry(bottomframe)
    TimeD.pack(padx=10, side=LEFT)
    button2 = Button(bottomframe, text="FFT Plot", fg="black", bg="silver")
    button2.pack(padx=250, side=LEFT)
    middleframe = Frame(window)
    middleframe.pack(side=BOTTOM)
    slider1 = Scale(middleframe, orient=HORIZONTAL, length=200, from_=0, to=4, sliderlength=20)
    slider1.pack(padx=100, pady=0, side=LEFT)
    slider2 = Scale(middleframe, orient=HORIZONTAL, length=200, from_=0, to=4, sliderlength=20)
    slider2.pack(padx=200, pady=0, side=LEFT)
    button1.config(command=lambda: Plot("Button-1", frame1, frame2, window, slider1, TimeD))
    slider1.config(command=lambda x: ChangePlot("Button-1", frame1, window, slider1, window.file))
    button2.config(command=lambda: FFTPlot("Button-1", frame2, window, window.file, slider2))
    slider2.config(command=lambda x: FFTPlot("Button-1", frame2, window, window.file, slider2))
    window.mainloop()


window = Tk.Tk()
window.file = 0
main()
