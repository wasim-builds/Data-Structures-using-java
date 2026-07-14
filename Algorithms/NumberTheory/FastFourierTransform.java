/**
 * Fast Fourier Transform (FFT) Skeleton
 * Polynomial multiplication in O(n log n).
 */
public class FastFourierTransform {
    // For simplicity, a basic structure is provided.
    // Full complex number operations would be implemented for a complete FFT.
    public void fft(double[] real, double[] imag, boolean invert) {
        int n = real.length;
        if (n == 1) return;
        
        double[] real0 = new double[n / 2];
        double[] imag0 = new double[n / 2];
        double[] real1 = new double[n / 2];
        double[] imag1 = new double[n / 2];
        
        for (int i = 0; 2 * i < n; i++) {
            real0[i] = real[2 * i];
            imag0[i] = imag[2 * i];
            real1[i] = real[2 * i + 1];
            imag1[i] = imag[2 * i + 1];
        }
        
        fft(real0, imag0, invert);
        fft(real1, imag1, invert);
        
        double angle = 2 * Math.PI / n * (invert ? -1 : 1);
        double wReal = 1, wImag = 0;
        double wnReal = Math.cos(angle), wnImag = Math.sin(angle);
        
        for (int i = 0; 2 * i < n; i++) {
            double uReal = real0[i];
            double uImag = imag0[i];
            
            double vReal = wReal * real1[i] - wImag * imag1[i];
            double vImag = wReal * imag1[i] + wImag * real1[i];
            
            real[i] = uReal + vReal;
            imag[i] = uImag + vImag;
            
            real[i + n / 2] = uReal - vReal;
            imag[i + n / 2] = uImag - vImag;
            
            if (invert) {
                real[i] /= 2;
                imag[i] /= 2;
                real[i + n / 2] /= 2;
                imag[i + n / 2] /= 2;
            }
            
            double nextWReal = wReal * wnReal - wImag * wnImag;
            double nextWImag = wReal * wnImag + wImag * wnReal;
            wReal = nextWReal;
            wImag = nextWImag;
        }
    }
}
