/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stripbandunk.alexvariasi.entity.user;

/**
 *
 * @author echo
 */
public enum HakAksesConstant {

    LIHAT_KATEGORI("Lihat Kategori"),
    TAMBAH_KATEGORI("Tambah Kategori"),
    UBAH_KATEGORI("Ubah Kategori"),
    HAPUS_KATEGORI("Hapus Kategori"),
    LIHAT_SATUAN("Lihat Satuan"),
    TAMBAH_SATUAN("Tambah Satuan"),
    UBAH_SATUAN("Ubah Satuan"),
    HAPUS_SATUAN("Hapus Satuan"),
    LIHAT_BARANG("Lihat Barang"),
    TAMBAH_BARANG("Tambah Barang"),
    UBAH_BARANG("Ubah Barang"),
    HAPUS_BARANG("HAPUS Barang"),
    LIHAT_DETAIL_BARANG("Lihat Detail Barang"),
    TAMBAH_DETAIL_BARANG("Tambah Detail Barang"),
    UBAH_DETAIL_BARANG("Ubah Detail Barang"),
    HAPUS_DETAIL_BARANG("Hapus Detail Barang"),
    LIHAT_PEMASOK("Lihat Pemasok"),
    TAMBAH_PEMASOK("Tambah Pemasok"),
    UBAH_PEMASOK("Ubah Pemasok"),
    HAPUS_PEMASOK("Hapus Pemasok"),
    LIHAT_PELANGGAN("Lihat Pelanggan"),
    TAMBAH_PELANGGAN("Tambah Pelanggan"),
    UBAH_PELANGGAN("Ubah Pelanggan"),
    HAPUS_PELANGGAN("Hapus Pelanggan"),
    LIHAT_PENJUAL("Lihat Penjual"),
    TAMBAH_PENJUAL("Tambah Penjual"),
    UBAH_PENJUAL("Ubah Penjual"),
    HAPUS_PENJUAL("Hapus Penjual"),
    LIHAT_JABATAN("Lihat Jabatan"),
    TAMBAH_JABATAN("Tambah Jabatan"),
    UBAH_JABATAN("Ubah Jabatan"),
    HAPUS_JABATAN("Hapus Jabatan"),
    LIHAT_KARYAWAN("Lihat Karyawan"),
    TAMBAH_KARYAWAN("Tambah Karyawan"),
    UBAH_KARYAWAN("Ubah Karyawan"),
    HAPUS_KARYAWAN("Hapus Karyawan"),
    LIHAT_GRUP("Lihat Grup"),
    TAMBAH_GRUP("Tambah Grup"),
    UBAH_GRUP("Ubah Grup"),
    HAPUS_GRUP("Hapus Grup"),
    LIHAT_PENGGUNA("Lihat Pengguna"),
    TAMBAH_PENGGUNA("Tambah Pengguna"),
    UBAH_PENGGUNA("Ubah Pengguna"),
    HAPUS_PENGGUNA("Hapus Pengguna"),
    TRANSAKSI_PENJUALAN("Transaksi Penjualan"),
    TRANSAKSI_PEMBELIAN("Transaksi Pembelian"),
    LIHAT_LAPORAN_PENJUALAN("Lihat Laporan Penjualan"),
    LIHAT_LAPORAN_PEMBELIAN("Lihat Laporan Pembelian"),
    LIHAT_LAPORAN_KEUNTUNGAN("Lihat Laporan Keuntungan");

    private String nama;

    private HakAksesConstant(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return nama;
    }
}
