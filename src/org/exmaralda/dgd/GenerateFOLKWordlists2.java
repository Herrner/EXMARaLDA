/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exmaralda.dgd;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.exmaralda.exakt.tokenlist.HashtableTokenList;
import org.jdom.JDOMException;

/**
 *
 * @author Schmidt
 */
public class GenerateFOLKWordlists2 {

    
    String[] ANT_01 = { "FR--_E_00001_SE_01_T_01_DF_01.FLN",
"FR--_E_00002_SE_01_T_01_DF_01.FLN",
"FR--_E_00003_SE_01_T_01_DF_01.FLN",
"FR--_E_00004_SE_01_T_01_DF_01.FLN",
"FR--_E_00005_SE_01_T_01_DF_01.FLN",
"FR--_E_00006_SE_01_T_01_DF_01.FLN",
"FR--_E_00007_SE_01_T_01_DF_01.FLN",
"FR--_E_00008_SE_01_T_01_DF_01.FLN",
"FR--_E_00009_SE_01_T_01_DF_01.FLN",
"FR--_E_00010_SE_01_T_01_DF_01.FLN",
"FR--_E_00011_SE_01_T_01_DF_01.FLN",
"FR--_E_00012_SE_01_T_01_DF_01.FLN",
"FR--_E_00013_SE_01_T_01_DF_01.FLN",
"FR--_E_00014_SE_01_T_01_DF_01.FLN",
"FR--_E_00015_SE_01_T_01_DF_01.FLN",
"FR--_E_00016_SE_01_T_01_DF_01.FLN",
"FR--_E_00017_SE_01_T_01_DF_01.FLN",
"FR--_E_00018_SE_01_T_01_DF_01.FLN",
"FR--_E_00019_SE_01_T_01_DF_01.FLN",
"FR--_E_00020_SE_01_T_01_DF_01.FLN",
"FR--_E_00021_SE_01_T_01_DF_01.FLN",
"FR--_E_00022_SE_01_T_01_DF_01.FLN",
"FR--_E_00023_SE_01_T_01_DF_01.FLN",
"FR--_E_00024_SE_01_T_01_DF_01.FLN",
"FR--_E_00025_SE_01_T_01_DF_01.FLN",
"FR--_E_00026_SE_01_T_01_DF_01.FLN",
"FR--_E_00027_SE_01_T_01_DF_01.FLN",
"FR--_E_00029_SE_01_T_01_DF_01.FLN",
"FR--_E_00030_SE_01_T_01_DF_01.FLN",
"FR--_E_00031_SE_01_T_01_DF_01.FLN",
"FR--_E_00032_SE_01_T_01_DF_01.FLN",
"FR--_E_00033_SE_01_T_01_DF_01.FLN",
"FR--_E_00034_SE_01_T_01_DF_01.FLN",
"FR--_E_00035_SE_01_T_01_DF_01.FLN",
"FR--_E_00036_SE_01_T_01_DF_01.FLN",
"FR--_E_00037_SE_01_T_01_DF_01.FLN",
"FR--_E_00038_SE_01_T_01_DF_01.FLN",
"FR--_E_00039_SE_01_T_01_DF_01.FLN",
"FR--_E_00040_SE_01_T_01_DF_01.FLN",
"FR--_E_00041_SE_01_T_01_DF_01.FLN",
"FR--_E_00042_SE_01_T_01_DF_01.FLN",
"FR--_E_00043_SE_01_T_01_DF_01.FLN",
"FR--_E_00044_SE_01_T_01_DF_01.FLN",
"FR--_E_00048_SE_01_T_01_DF_01.FLN",
"FR--_E_00051_SE_01_T_01_DF_01.FLN",
"FR--_E_00052_SE_01_T_01_DF_01.FLN",
"FR--_E_00053_SE_01_T_01_DF_01.FLN",
"FR--_E_00055_SE_01_T_01_DF_01.FLN",
"FR--_E_00057_SE_01_T_01_DF_01.FLN",
"FR--_E_00058_SE_01_T_01_DF_01.FLN",
"FR--_E_00060_SE_01_T_01_DF_01.FLN",
"FR--_E_00061_SE_01_T_01_DF_01.FLN",
"FR--_E_00066_SE_01_T_01_DF_01.FLN",
"FR--_E_00067_SE_01_T_01_DF_01.FLN",
"FR--_E_00069_SE_01_T_01_DF_01.FLN",
"FR--_E_00070_SE_01_T_01_DF_01.FLN",
"FR--_E_00071_SE_01_T_01_DF_01.FLN",
"FR--_E_00072_SE_01_T_01_DF_01.FLN",
"FR--_E_00074_SE_01_T_01_DF_01.FLN",
"FR--_E_00075_SE_01_T_01_DF_01.FLN",
"FR--_E_00076_SE_01_T_01_DF_01.FLN",
"FR--_E_00077_SE_01_T_01_DF_01.FLN",
"FR--_E_00078_SE_01_T_01_DF_01.FLN",
"FR--_E_00080_SE_01_T_01_DF_01.FLN",
"FR--_E_00081_SE_01_T_01_DF_01.FLN",
"FR--_E_00082_SE_01_T_01_DF_01.FLN",
"FR--_E_00083_SE_01_T_01_DF_01.FLN",
"FR--_E_00084_SE_01_T_01_DF_01.FLN",
"FR--_E_00085_SE_01_T_01_DF_01.FLN",
"FR--_E_00086_SE_01_T_01_DF_01.FLN",
"FR--_E_00088_SE_01_T_01_DF_01.FLN",
"FR--_E_00089_SE_01_T_01_DF_01.FLN",
"FR--_E_00091_SE_01_T_01_DF_01.FLN",
"FR--_E_00092_SE_01_T_01_DF_01.FLN",
"FR--_E_00093_SE_01_T_01_DF_01.FLN",
"FR--_E_00094_SE_01_T_01_DF_01.FLN",
"FR--_E_00099_SE_01_T_01_DF_01.FLN",
"FR--_E_00101_SE_01_T_01_DF_01.FLN",
"FR--_E_00180_SE_01_T_01_DF_01.FLN",
"FR--_E_00181_SE_01_T_01_DF_01.FLN",
"FR--_E_00182_SE_01_T_01_DF_01.FLN",
"FR--_E_00186_SE_01_T_01_DF_01.FLN",
"FR--_E_00188_SE_01_T_01_DF_01.FLN",
"FR--_E_00189_SE_01_T_01_DF_01.FLN",
"FR--_E_00190_SE_01_T_01_DF_01.FLN",
"FR--_E_00191_SE_01_T_01_DF_01.FLN",
"FR--_E_00192_SE_01_T_01_DF_01.FLN",
"FR--_E_00193_SE_01_T_01_DF_01.FLN",
"FR--_E_00195_SE_01_T_01_DF_01.FLN",
};

    String[] ANT_02 = { "FR--_E_00045_SE_01_T_01_DF_01.FLN",
"FR--_E_00046_SE_01_T_01_DF_01.FLN",
"FR--_E_00047_SE_01_T_01_DF_01.FLN",
"FR--_E_00049_SE_01_T_01_DF_01.FLN",
"FR--_E_00050_SE_01_T_01_DF_01.FLN",
"FR--_E_00054_SE_01_T_01_DF_01.FLN",
"FR--_E_00056_SE_01_T_01_DF_01.FLN",
"FR--_E_00059_SE_01_T_01_DF_01.FLN",
"FR--_E_00062_SE_01_T_01_DF_01.FLN",
"FR--_E_00063_SE_01_T_01_DF_01.FLN",
"FR--_E_00064_SE_01_T_01_DF_01.FLN",
"FR--_E_00065_SE_01_T_01_DF_01.FLN",
"FR--_E_00068_SE_01_T_01_DF_01.FLN",
"FR--_E_00073_SE_01_T_01_DF_01.FLN",
"FR--_E_00079_SE_01_T_01_DF_01.FLN",
"FR--_E_00087_SE_01_T_01_DF_01.FLN",
"FR--_E_00090_SE_01_T_01_DF_01.FLN",
"FR--_E_00095_SE_01_T_01_DF_01.FLN",
"FR--_E_00096_SE_01_T_01_DF_01.FLN",
"FR--_E_00097_SE_01_T_01_DF_01.FLN",
"FR--_E_00098_SE_01_T_01_DF_01.FLN",
"FR--_E_00100_SE_01_T_01_DF_01.FLN",
"FR--_E_00102_SE_01_T_01_DF_01.FLN",
"FR--_E_00103_SE_01_T_01_DF_01.FLN",
"FR--_E_00104_SE_01_T_01_DF_01.FLN",
"FR--_E_00105_SE_01_T_01_DF_01.FLN",
"FR--_E_00106_SE_01_T_01_DF_01.FLN",
"FR--_E_00107_SE_01_T_01_DF_01.FLN",
"FR--_E_00108_SE_01_T_01_DF_01.FLN",
"FR--_E_00109_SE_01_T_01_DF_01.FLN",
"FR--_E_00110_SE_01_T_01_DF_01.FLN",
"FR--_E_00111_SE_01_T_01_DF_01.FLN",
"FR--_E_00112_SE_01_T_01_DF_01.FLN",
"FR--_E_00113_SE_01_T_01_DF_01.FLN",
"FR--_E_00114_SE_01_T_01_DF_01.FLN",
"FR--_E_00115_SE_01_T_01_DF_01.FLN",
"FR--_E_00116_SE_01_T_01_DF_01.FLN",
"FR--_E_00117_SE_01_T_01_DF_01.FLN",
"FR--_E_00118_SE_01_T_01_DF_01.FLN",
"FR--_E_00119_SE_01_T_01_DF_01.FLN",
"FR--_E_00120_SE_01_T_01_DF_01.FLN",
"FR--_E_00121_SE_01_T_01_DF_01.FLN",
"FR--_E_00122_SE_01_T_01_DF_01.FLN",
"FR--_E_00123_SE_01_T_01_DF_01.FLN",
"FR--_E_00124_SE_01_T_01_DF_01.FLN",
"FR--_E_00125_SE_01_T_01_DF_01.FLN",
"FR--_E_00126_SE_01_T_01_DF_01.FLN",
"FR--_E_00127_SE_01_T_01_DF_01.FLN",
"FR--_E_00128_SE_01_T_01_DF_01.FLN",
"FR--_E_00129_SE_01_T_01_DF_01.FLN",
"FR--_E_00130_SE_01_T_01_DF_01.FLN",
"FR--_E_00131_SE_01_T_01_DF_01.FLN",
"FR--_E_00132_SE_01_T_01_DF_01.FLN",
"FR--_E_00133_SE_01_T_01_DF_01.FLN",
"FR--_E_00134_SE_01_T_01_DF_01.FLN",
"FR--_E_00135_SE_01_T_01_DF_01.FLN",
"FR--_E_00136_SE_01_T_01_DF_01.FLN",
"FR--_E_00137_SE_01_T_01_DF_01.FLN",
"FR--_E_00138_SE_01_T_01_DF_01.FLN",
"FR--_E_00139_SE_01_T_01_DF_01.FLN",
"FR--_E_00140_SE_01_T_01_DF_01.FLN",
"FR--_E_00141_SE_01_T_01_DF_01.FLN",
"FR--_E_00142_SE_01_T_01_DF_01.FLN",
"FR--_E_00143_SE_01_T_01_DF_01.FLN",
"FR--_E_00144_SE_01_T_01_DF_01.FLN",
"FR--_E_00145_SE_01_T_01_DF_01.FLN",
"FR--_E_00146_SE_01_T_01_DF_01.FLN",
"FR--_E_00147_SE_01_T_01_DF_01.FLN",
"FR--_E_00148_SE_01_T_01_DF_01.FLN",
"FR--_E_00149_SE_01_T_01_DF_01.FLN",
"FR--_E_00150_SE_01_T_01_DF_01.FLN",
"FR--_E_00151_SE_01_T_01_DF_01.FLN",
"FR--_E_00152_SE_01_T_01_DF_01.FLN",
"FR--_E_00153_SE_01_T_01_DF_01.FLN",
"FR--_E_00154_SE_01_T_01_DF_01.FLN",
"FR--_E_00155_SE_01_T_01_DF_01.FLN",
"FR--_E_00156_SE_01_T_01_DF_01.FLN",
"FR--_E_00157_SE_01_T_01_DF_01.FLN",
"FR--_E_00158_SE_01_T_01_DF_01.FLN",
"FR--_E_00159_SE_01_T_01_DF_01.FLN",
"FR--_E_00160_SE_01_T_01_DF_01.FLN",
"FR--_E_00161_SE_01_T_01_DF_01.FLN",
"FR--_E_00162_SE_01_T_01_DF_01.FLN",
"FR--_E_00163_SE_01_T_01_DF_01.FLN",
"FR--_E_00164_SE_01_T_01_DF_01.FLN",
"FR--_E_00165_SE_01_T_01_DF_01.FLN",
"FR--_E_00166_SE_01_T_01_DF_01.FLN",
"FR--_E_00167_SE_01_T_01_DF_01.FLN",
"FR--_E_00168_SE_01_T_01_DF_01.FLN",
"FR--_E_00169_SE_01_T_01_DF_01.FLN",
"FR--_E_00170_SE_01_T_01_DF_01.FLN",
"FR--_E_00171_SE_01_T_01_DF_01.FLN",
"FR--_E_00172_SE_01_T_01_DF_01.FLN",
"FR--_E_00173_SE_01_T_01_DF_01.FLN",
"FR--_E_00174_SE_01_T_01_DF_01.FLN",
"FR--_E_00175_SE_01_T_01_DF_01.FLN",
"FR--_E_00176_SE_01_T_01_DF_01.FLN",
"FR--_E_00177_SE_01_T_01_DF_01.FLN",
"FR--_E_00178_SE_01_T_01_DF_01.FLN",
"FR--_E_00179_SE_01_T_01_DF_01.FLN",
"FR--_E_00183_SE_01_T_01_DF_01.FLN",
"FR--_E_00184_SE_01_T_01_DF_01.FLN",
"FR--_E_00185_SE_01_T_01_DF_01.FLN",
"FR--_E_00187_SE_01_T_01_DF_01.FLN",
"FR--_E_00194_SE_01_T_01_DF_01.FLN",
"FR--_E_00196_SE_01_T_01_DF_01.FLN",
"FR--_E_00197_SE_01_T_01_DF_01.FLN",
"FR--_E_00198_SE_01_T_01_DF_01.FLN",
"FR--_E_00199_SE_01_T_01_DF_01.FLN",
"FR--_E_00200_SE_01_T_01_DF_01.FLN",
"FR--_E_00201_SE_01_T_01_DF_01.FLN",
"FR--_E_00202_SE_01_T_01_DF_01.FLN",
"FR--_E_00203_SE_01_T_01_DF_01.FLN",
"FR--_E_00204_SE_01_T_01_DF_01.FLN",
"FR--_E_00205_SE_01_T_01_DF_01.FLN",
"FR--_E_00206_SE_01_T_01_DF_01.FLN",
"FR--_E_00207_SE_01_T_01_DF_01.FLN",
"FR--_E_00208_SE_01_T_01_DF_01.FLN",
"FR--_E_00209_SE_01_T_01_DF_01.FLN",
"FR--_E_00210_SE_01_T_01_DF_01.FLN",
"FR--_E_00211_SE_01_T_01_DF_01.FLN",
"FR--_E_00212_SE_01_T_01_DF_01.FLN",
"FR--_E_00213_SE_01_T_01_DF_01.FLN",
"FR--_E_00214_SE_01_T_01_DF_01.FLN",
"FR--_E_00215_SE_01_T_01_DF_01.FLN",
"FR--_E_00216_SE_01_T_01_DF_01.FLN",
"FR--_E_00217_SE_01_T_01_DF_01.FLN",
"FR--_E_00218_SE_01_T_01_DF_01.FLN",
"FR--_E_00219_SE_01_T_01_DF_01.FLN",
"FR--_E_00220_SE_01_T_01_DF_01.FLN",
"FR--_E_00221_SE_01_T_01_DF_01.FLN",
"FR--_E_00222_SE_01_T_01_DF_01.FLN",
};

    String[] ALL = {"FR--_E_00180_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00221_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00222_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00218_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00219_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00220_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00212_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00213_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00214_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00215_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00216_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00217_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00209_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00210_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00211_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00205_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00206_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00207_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00208_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00201_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00202_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00203_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00204_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00196_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00197_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00198_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00199_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00200_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00190_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00191_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00192_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00193_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00194_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00195_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00189_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00185_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00186_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00187_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00188_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00183_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00184_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00182_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00179_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00181_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00172_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00173_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00174_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00175_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00176_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00177_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00178_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00164_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00165_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00166_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00167_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00168_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00169_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00170_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00171_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00155_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00156_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00157_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00158_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00159_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00160_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00161_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00162_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00163_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00145_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00146_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00147_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00148_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00149_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00150_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00151_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00152_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00153_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00154_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00138_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00139_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00140_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00141_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00142_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00143_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00144_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00134_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00135_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00136_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00137_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00131_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00132_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00133_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00127_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00128_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00129_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00130_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00123_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00124_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00125_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00120_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00121_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00122_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00112_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00113_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00114_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00115_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00117_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00118_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00107_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00108_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00110_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00111_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00103_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00104_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00105_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00106_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00098_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00099_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00100_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00101_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00102_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00092_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00093_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00094_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00095_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00096_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00097_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00082_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00083_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00084_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00085_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00086_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00087_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00088_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00089_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00090_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00091_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00075_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00076_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00077_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00078_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00079_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00080_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00081_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00066_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00067_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00068_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00069_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00070_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00071_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00072_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00073_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00074_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00063_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00065_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00058_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00059_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00060_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00061_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00062_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00056_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00057_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00054_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00055_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00049_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00050_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00051_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00052_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00053_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00044_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00045_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00046_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00047_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00048_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00042_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00043_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00029_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00030_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00031_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00033_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00034_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00035_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00036_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00037_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00038_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00039_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00040_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00041_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00024_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00026_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00017_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00018_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00020_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00021_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00023_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00013_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00010_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00011_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00012_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00008_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00009_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00004_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00005_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00006_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00007_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00001_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00002_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00003_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00109_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00116_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00119_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00126_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00025_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00027_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00032_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00064_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00014_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00015_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00016_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00019_SE_01_T_01_DF_01.FLN",
                    "FR--_E_00022_SE_01_T_01_DF_01.FLN"};

    
    File transcriptDirectory;
    HashtableTokenList tokenlist = new HashtableTokenList();
            
    public GenerateFOLKWordlists2(String transcriptPath) {
        transcriptDirectory = new File(transcriptPath);
    }
    
    void makeWordlist() throws JDOMException, IOException{
        File[] transcriptFiles = new File[ANT_01.length];
        int i=0;
        for (String filename : ANT_01){
            transcriptFiles[i] = new File(transcriptDirectory, filename);
            i++;        
        }
        tokenlist.readWordsFromFolkerFiles(transcriptFiles);        
    }
    
    void writeWordList(String xmlPath) throws IOException{
        tokenlist.write(new File(xmlPath));
    }

    
    static String IN = "Y:\\thomas\\DGD-Transkripte\\FR";
    static String OUT = "Y:\\thomas\\FR2FLK\\ANT_01_Wordlist.xml";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            GenerateFOLKWordlists2 gfw = new GenerateFOLKWordlists2(IN);
            /*HashSet<String> ANT_01_SET = new HashSet<String>();
            for (String x : gfw.ANT_01){
                ANT_01_SET.add(x);
            }
            HashSet<String> ANT_02_SET = new HashSet<String>();
            for (String x : gfw.ANT_02){
                ANT_02_SET.add(x);
            }
            
            HashSet<String> ANT_ALL = new HashSet<String>();
            for (String x : gfw.ALL){
                ANT_ALL.add(x);
            }
            
            System.out.println(ANT_ALL.size() + " files alltogether");

            //ANT_02_SET.retainAll(ANT_01_SET);
            
            ANT_ALL.removeAll(ANT_01_SET);
            ANT_ALL.removeAll(ANT_02_SET);
            
            for (String x : ANT_ALL){
                System.out.println(x);
            }*/
            
            gfw.makeWordlist();
            gfw.writeWordList(OUT);
        } catch (JDOMException ex) {
            Logger.getLogger(GenerateFOLKWordlists2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenerateFOLKWordlists2.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
}
